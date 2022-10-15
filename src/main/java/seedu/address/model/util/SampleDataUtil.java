package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Student(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Gender("M"),
                getTagSet("friends"), new Location("Chess club room")),
            new Student(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Gender("M"),
                getTagSet("colleagues", "friends"), new Location("UTown")),
            new Student(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Gender("F"),
                getTagSet("neighbours"), new Location("NUS")),
            new Professor(new Name("Wong Tin Lok"), new ModuleCode("CS1231S"),
                new Phone("91031282"), new Email("wongtk@example.com"),
                new Gender("M"),
                getTagSet("family"), new Location("COM2 LT4"), new Rating("5")),
            new TeachingAssistant(new Name("Irfan Ibrahim"), new ModuleCode("CS2100"), new Phone("92492021"),
                new Email("irfan@example.com"),
                new Gender("M"),
                getTagSet("testing"), new Location("COM2-0210"), new Rating("4")),
            new Student(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Gender("M"),
                getTagSet("colleagues"), new Location("Research Lab"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
