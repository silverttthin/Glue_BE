package org.glue.glue_be.chat.entity;


import jakarta.persistence.*;
import lombok.*;
import org.glue.glue_be.common.BaseEntity;
import org.glue.glue_be.user.entity.User;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "message")
public class Message extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private Long messageId;

	// Message와 User는 매개 테이블 없이 직접적인 연관관계를 매핑
	// 따라서 반대측인 User에서 OneToMany를 작성할 필요 없음
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chatroom_id", nullable = false)
	private ChatRoom chatRoom;

	// 추후 이부분을 일반 속성인 uuid로 대체해야 할지 결정해야함
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "message_content", columnDefinition = "TEXT", nullable = false)
	private String messageContent;

	@Builder
	private Message(ChatRoom chatRoom, User user, String messageContent){
		this.chatRoom = chatRoom;
		this.user = user;
		this.messageContent = messageContent;
	}

	public void changeMessageContent(String newMessageContent) { this.messageContent = newMessageContent; }

}
