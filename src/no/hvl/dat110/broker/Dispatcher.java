package no.hvl.dat110.broker;

import java.util.Set;
import java.util.Collection;
import java.util.Iterator;

import no.hvl.dat110.common.TODO;
import no.hvl.dat110.common.Logger;
import no.hvl.dat110.common.Stopable;
import no.hvl.dat110.messages.*;
import no.hvl.dat110.messagetransport.Connection;

public class Dispatcher extends Stopable
{

	private Storage storage;

	public Dispatcher(Storage storage)
	{
		super("Dispatcher");
		this.storage = storage;

	}

	@Override
	public void doProcess()
	{

		Collection<ClientSession> clients = storage.getSessions();

		Logger.lg(".");
		for (ClientSession client : clients)
		{

			Message msg = null;

			if (client.hasData())
			{
				msg = client.receive();
			}

			// a message was received
			if (msg != null)
			{
				dispatch(client, msg);
			}
		}

		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void dispatch(ClientSession client, Message msg)
	{

		MessageType type = msg.getType();

		// invoke the appropriate handler method
		switch (type)
		{

		case DISCONNECT:
			onDisconnect((DisconnectMsg) msg);
			break;

		case CREATETOPIC:
			onCreateTopic((CreateTopicMsg) msg);
			break;

		case DELETETOPIC:
			onDeleteTopic((DeleteTopicMsg) msg);
			break;

		case SUBSCRIBE:
			onSubscribe((SubscribeMsg) msg);
			break;

		case UNSUBSCRIBE:
			onUnsubscribe((UnsubscribeMsg) msg);
			break;

		case PUBLISH:
			onPublish((PublishMsg) msg);
			break;

		default:
			Logger.log("broker dispatch - unhandled message type");
			break;

		}
	}

	// called from Broker after having established the underlying connection
	public void onConnect(ConnectMsg msg, Connection connection)
	{

		String user = msg.getUser();

		Logger.log("onConnect:" + msg.toString());

		
		
		Set<PublishMsg> messages = storage.getBufferedMessages(user);
		
		if (messages == null)
		{
			storage.addClientSession(user, connection);
		}
		
		else 
		{
			storage.addClientSession(user, connection);
			for (Message m : messages)
			{
				storage.getSession(user).send(m);
			}
		}
	}

	// called by dispatch upon receiving a disconnect message
	public void onDisconnect(DisconnectMsg msg)
	{

		String user = msg.getUser();

		Logger.log("onDisconnect:" + msg.toString());

		storage.removeClientSession(user);

	}

	public void onCreateTopic(CreateTopicMsg msg)
	{
		Logger.log("onCreateTopic:" + msg.toString());

		storage.createTopic(msg.getTopic());

	}

	public void onDeleteTopic(DeleteTopicMsg msg)
	{

		Logger.log("onDeleteTopic:" + msg.toString());

		storage.deleteTopic(msg.getTopic());
	}

	public void onSubscribe(SubscribeMsg msg)
	{

		Logger.log("onSubscribe:" + msg.toString());

		String user = msg.getUser();
		String topic = msg.getTopic();

		storage.addSubscriber(user, topic);

	}

	public void onUnsubscribe(UnsubscribeMsg msg)
	{

		Logger.log("onUnsubscribe:" + msg.toString());

		String user = msg.getUser();
		String topic = msg.getTopic();

		storage.removeSubscriber(user, topic);

	}

	public void onPublish(PublishMsg msg)
	{

		Logger.log("onPublish:" + msg.toString());

		String topic = msg.getTopic();

		Set<String> subs = storage.getSubscribers(topic);

		if (subs == null)
		{
			return;
		}

		Iterator<String> itr = subs.iterator();

		while (itr.hasNext())
		{
			String s = itr.next();
			ClientSession session = storage.getSession(s);
			if (session != null)
			{
				session.send(msg);
			} else
			{
				storage.addToBufferedMessages(s, msg);
			}
		}
	}
}
