package no.hvl.dat110.messages;

<<<<<<< HEAD
public class PublishMsg extends Message
{

	private String topic;
	private String message;

	public PublishMsg(String topic, String message, String user)
	{
=======
public class PublishMsg extends Message {
	
	private String topic;
	private String message;
	
	public PublishMsg(String topic, String message, String user) {
>>>>>>> 60863c759fcab627ede78c7688d436c55498cee0
		super(MessageType.PUBLISH, user);
		this.message = message;
		this.topic = topic;
	}

<<<<<<< HEAD
	public String getTopic()
	{
		return topic;
	}

	public void setTopic(String topic)
	{
		this.topic = topic;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
=======
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
>>>>>>> 60863c759fcab627ede78c7688d436c55498cee0
		this.message = message;
	}

	@Override
<<<<<<< HEAD
	public String toString()
	{
		return "PublishMsg [topic = " + topic + " , message = " + message + super.toString() + "]";
	}

	// message sent from client to create publish a message on a topic
=======
	public String toString() {
		return "PublishMsg [topic = " + topic + " , message = " + message + super.toString() + "]";
	}
	
	
	
	// message sent from client to create publish a message on a topic 
>>>>>>> 60863c759fcab627ede78c7688d436c55498cee0

	// TODO:
	// Implement object variables - a topic and a message is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text

}