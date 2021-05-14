package com.DAI.ProChild.Chat;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends PagingAndSortingRepository<ChatMessage, Long> {
}
