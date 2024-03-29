package io.qdivision.qtp.title;

import io.qdivision.qtp.name.Name;
import io.qdivision.qtp.name.NameEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static io.qdivision.qtp.title.TitleConversions.toTitle;


@RestController
@RequestMapping("title")
public class TitleController {

    private final TitleRepository titleRepository;

    public TitleController(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    @GetMapping
    public List<Title> getAllTitle(@RequestParam(value = "titleId", defaultValue = "") Long titleId) {
        List<Title> titles =
                        titleRepository.findAll()
                                .stream()
                                .map(titleEntity -> toTitle(titleEntity))
                                .collect(Collectors.toList());
        return
            titleId == null ?
                titles
            :
                titles
                .stream()
                .filter(title -> title.getId().equals(titleId))
                .collect(Collectors.toList());


    }

    @GetMapping("{startYear}/{endYear}")
    public List<Title> getTitleBetweenYears(@PathVariable("startYear")Integer startYear, @PathVariable("endYear")Integer endYear) {
        return titleRepository.findByStartYearIsBetween(startYear,endYear)
                .stream()
                .map(TitleConversions::toTitle)
                .collect(Collectors.toList());
    }

    @GetMapping("{movieName}")
    public List<Title> getByName(@PathVariable("movieName")String movieName){
        return titleRepository.findByPrimaryTitleContaining(movieName)
                .stream()
                .map(TitleConversions::toTitle)
                .collect(Collectors.toList());
    }

    @PostMapping
    @RequestMapping("{id}/favorite")
    public Title saveFavorite(@PathVariable("id") Long id) {
        TitleEntity updatedTitle = titleRepository.findById(id)
                .map(toUpdate -> {
                    toUpdate.setFavorite(!toUpdate.getFavorite());

                    return toUpdate;
                })
                .orElseThrow(() -> new RuntimeException("Favorites not found to update"));
        return toTitle(titleRepository.saveAndFlush(updatedTitle));
    }


    @GetMapping
    @RequestMapping("favorites")
    public List<Title> getFavorites() {

        return titleRepository.findAll()
                .stream()
                .filter(titleEntity -> titleEntity.getFavorite() == true)
                .map(titleEntity -> toTitle(titleEntity))
                .collect(Collectors.toList());
    }
}
