package io.qdivision.qtp.title;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("title")
public class TitleController {

    private final TitleRepository titleRepository;

    public TitleController(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    @GetMapping
    public List<Title> getTitle() {
        return titleRepository.findAll()
                .stream()
                .map(titleEntity -> toTitle(titleEntity))
                .collect(Collectors.toList());
    }

    private Title toTitle(TitleEntity title) {
        return Title.builder()
                .id(title.getId())
                .tconst(title.getTconst())
                .title_type(title.getTitle_type())
                .primary_title(title.getPrimary_title())
                .original_title(title.getOriginal_title())
                .is_adult(title.getIs_adult())
                .start_year(title.getStart_year())
                .end_year(title.getEnd_year())
                .runtime_minutes(title.getRuntime_minutes())
                .genres(title.getGenres())
                .build();
    }
}
