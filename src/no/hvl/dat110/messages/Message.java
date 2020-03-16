package no.hvl.dat110.messages;

public abstract class Message
{

	// base class for messages exchanged between broker and clients
	private MessageType type;
	private String user;

	public Message()
	{

	}

	public Message(MessageType type, String user)
	{
		this.type = type;
		this.user = user;
	}

	public MessageType getType()
	{
		return this.type;
	}

	public String getUser()
	{
		return user;
	}

	@Override
<<<<<<< HEAD
	public String toString()
	{
=======
	public String toString() {
>>>>>>> 60863c759fcab627ede78c7688d436c55498cee0
		return "Message [type = " + type + ", user = " + user + "]";
	};

}