package no.hvl.dat110.messages;

<<<<<<< HEAD
public class SubscribeMsg extends Message
{
=======
public class SubscribeMsg extends Message {
	
	private String topic;
	
	public SubscribeMsg(String topic, String user) {
		super(MessageType.SUBSCRIBE, user);
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "SubscribeMsg [topic = " + topic + super.toString() + "]";
	}
	
	
>>>>>>> 60863c759fcab627ede78c7688d436c55498cee0

	private String topic;

	public SubscribeMsg(String topic, String user)
	{
		super(MessageType.SUBSCRIBE, user);
		this.topic = topic;
	}

	public String getTopic()
	{
		return topic;
	}

	public void setTopic(String topic)
	{
		this.topic = topic;
	}

	@Override
	public String toString()
	{
		return "SubscribeMsg [topic = " + topic + super.toString() + "]";
	}

	// message sent from client to subscribe on a topic

	// TODO:
	// Implement object variables - a topic is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text

}