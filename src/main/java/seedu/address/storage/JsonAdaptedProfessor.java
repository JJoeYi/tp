package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Email;
import seedu.address.model.person.Gender;
import seedu.address.model.person.Location;
import seedu.address.model.person.ModuleCode;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Professor;
import seedu.address.model.person.Rating;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Professor}.
 */
class JsonAdaptedProfessor extends JsonAdaptedPerson {

    /**
     * Constructs a {@code JsonAdaptedProfessor} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedProfessor(@JsonProperty("type") String type, @JsonProperty("name") String name,
                                @JsonProperty("moduleCode") String moduleCode, @JsonProperty("phone") String phone,
                                @JsonProperty("email") String email, @JsonProperty("gender") String gender,
                                @JsonProperty("tagged") List<JsonAdaptedTag> tagged,
                                @JsonProperty("location") String location,
                                @JsonProperty("rating") String rating) {
        super(type, name, moduleCode, phone, email, gender, tagged, location, rating);
    }

    /**
     * Converts a given {@code Professor} into this class for Jackson use.
     */
    public JsonAdaptedProfessor(Professor source) {
        super(source);
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Professor} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted Professor.
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : getTagged()) {
            personTags.add(tag.toModelType());
        }

        if (getName() == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(getName())) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(getName());

        if (getPhone() == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(getPhone())) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(getPhone());

        if (getEmail() == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(getEmail())) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(getEmail());

        if (getGender() == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Gender.class.getSimpleName()));
        }
        if (!Gender.isValidGender(getGender())) {
            throw new IllegalValueException(Gender.MESSAGE_CONSTRAINTS);
        }
        final Gender modelGender = new Gender(getGender());

        if (getModuleCode() == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                ModuleCode.class.getSimpleName()));
        }
        if (!ModuleCode.isValidModuleCode(getModuleCode())) {
            throw new IllegalValueException(Gender.MESSAGE_CONSTRAINTS);
        }
        final ModuleCode modelModuleCode = new ModuleCode(getModuleCode());

        final Set<Tag> modelTags = new HashSet<>(personTags);

        if (getLocation() == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                Location.class.getSimpleName()));
        }

        if (!Location.isValidLocation(getLocation())) {
            throw new IllegalValueException(Location.MESSAGE_CONSTRAINTS);
        }

        final Location modelLocation = new Location(getLocation());

        if (getRating() == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Rating.class.getSimpleName()));
        }
        if (!Rating.isValidRating(getRating())) {
            throw new IllegalValueException(Rating.MESSAGE_CONSTRAINTS);
        }
        final Rating modelRating = new Rating(getRating());

        return new Professor(modelName, modelModuleCode, modelPhone, modelEmail, modelGender, modelTags,
            modelLocation, modelRating);
    }

}
