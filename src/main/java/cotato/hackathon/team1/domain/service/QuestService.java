package cotato.hackathon.team1.domain.service;

import cotato.hackathon.team1.common.exception.ImageException;
import cotato.hackathon.team1.common.s3.S3Uploader;
import cotato.hackathon.team1.domain.entity.Quest;
import cotato.hackathon.team1.domain.entity.QuestHistory;
import cotato.hackathon.team1.domain.entity.User;
import cotato.hackathon.team1.domain.repository.QuestHistoryRepository;
import cotato.hackathon.team1.domain.repository.QuestRepository;
import cotato.hackathon.team1.domain.repository.UserRepository;
import cotato.hackathon.team1.web.dto.SubmitQuestRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuestService {

    private static final String QUEST_HISTORY_DIR = "QuestHistory";
    private final QuestRepository questRepository;
    private final QuestHistoryRepository questHistoryRepository;
    private final UserRepository userRepository;
    private final S3Uploader s3Uploader;

    @Transactional
    public void submitQuest(SubmitQuestRequest request) throws ImageException {
        Quest findQuest = questRepository.findById(request.questId())
                .orElseThrow(() -> new EntityNotFoundException("해당 퀘스트를 조회할 수 없습니다."));

        User findUser = userRepository.findById(request.userId())
                .orElseThrow(() -> new EntityNotFoundException("해당 유저를 찾을 수 없습니다."));

        questHistoryRepository.save(QuestHistory.builder()
                .questId(findQuest.getId())
                .user(findUser)
                .url(s3Uploader.uploadFiles(request.image(), QUEST_HISTORY_DIR))
                .build());
    }
}
