
package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {
	
	private String topic;
	
	public DeleteTopicMsg(String topic, String user) {
		super(MessageType.DELETETOPIC, user);
		this.topic = topic;
	}

	public String getTopic()
	{
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String toString() {
		return "DeleteTopicMsg [topic = " + topic + super.toString() + "]";
	}


	// message sent from client to create topic on the broker

	// TODO:
	// Implement object variables - a topic is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text

}