package no.hvl.dat110.messages;

public class PublishMsg extends Message {
	
	private String topic;
	private String message;
	
	public PublishMsg(String topic, String message, String user) {
		super(MessageType.PUBLISH, user);
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String toString() {
		return "PublishMsg [topic = " + topic + " , message = " + message + super.toString() + "]";
	}
}