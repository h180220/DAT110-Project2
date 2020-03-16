
package no.hvl.dat110.messages;

<<<<<<< HEAD
public class DeleteTopicMsg extends Message
{

	private String topic;

	public DeleteTopicMsg(String topic, String user)
	{
=======
public class DeleteTopicMsg extends Message {
	
	private String topic;
	
	public DeleteTopicMsg(String topic, String user) {
>>>>>>> 60863c759fcab627ede78c7688d436c55498cee0
		super(MessageType.DELETETOPIC, user);
		this.topic = topic;
	}

<<<<<<< HEAD
	public String getTopic()
	{
		return topic;
	}

	public void setTopic(String topic)
	{
=======
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
>>>>>>> 60863c759fcab627ede78c7688d436c55498cee0
		this.topic = topic;
	}

	@Override
<<<<<<< HEAD
	public String toString()
	{
		return "DeleteTopicMsg [topic = " + topic + super.toString() + "]";
	}
=======
	public String toString() {
		return "DeleteTopicMsg [topic = " + topic + super.toString() + "]";
	}
	
	
>>>>>>> 60863c759fcab627ede78c7688d436c55498cee0

	// message sent from client to create topic on the broker

	// TODO:
	// Implement object variables - a topic is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text

}