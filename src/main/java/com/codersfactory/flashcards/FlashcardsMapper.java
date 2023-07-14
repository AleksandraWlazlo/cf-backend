package com.codersfactory.flashcards;

import com.codersfactory.flashcards.dto.CreateFlashcardDto;
import com.codersfactory.flashcards.dto.FlashcardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
interface FlashcardsMapper {

    FlashcardsMapper INSTANCE = Mappers.getMapper(FlashcardsMapper.class);

    @Mapping(target = "flashcardCollection",
            expression = "java(service.findById(dto.flashcardCollection()))")
    Flashcard flashcardToEntity(CreateFlashcardDto dto, FlashcardCollectionsService service);

    default FlashcardDto toDto(Flashcard card) {
        return new FlashcardDto(card.getId(), card.getFront(), card.getBack(), card.getFlashcardCollection().getId());
    }
}
