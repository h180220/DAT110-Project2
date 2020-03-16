package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message
{

	private String topic;

	public CreateTopicMsg(String topic, String user)
	{
		super(MessageType.CREATETOPIC, user);
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
<<<<<<< HEAD
	public String toString()
	{
=======
	public String toString() {
>>>>>>> 60863c759fcab627ede78c7688d436c55498cee0
		return "CreateTopicMsg [topic = " + topic + super.toString() + "]";
	}

	// message sent from client to create topic on the broker

	// TODO:
	// Implement object variables - a topic is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text
}