package collectionFramework;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {

	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		// 메시지 저장
		messageQueue.offer(new Message("sendMail", "ABC"));
		messageQueue.offer(new Message("sendSMS", "DEF"));
		messageQueue.offer(new Message("sendKakaotalk", "GHI"));
		
		while(!messageQueue.isEmpty()) { // 메시지 큐가 비어있는지 확인
			// 메시지 큐에서 한 개의 메시지 꺼냄
			Message message = messageQueue.poll();
			switch(message.command) {
			case "sendMail":
				System.out.println(message.to + " 님에게 메일을 전송");
				break;
			case "sendSMS":
				System.out.println(message.to + " 님에게 SMS를 전송");
				break;
			case "sendKakaotalk":
				System.out.println(message.to + " 님에게 Kakaotalk 전송");
				break;
			}
		}
	}
}
