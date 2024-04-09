

import java.util.HashMap;
import java.util.Map;

public class PersonRepository {

    static Map<Integer, PersonQ3> personMap = new HashMap<Integer, PersonQ3>();
    SequenceGenerator sequenceGenerator;

    public PersonQ3 save(PersonQ3 person) {
        if(person.getId() != null) {
            throw new RuntimeException("PersonQ3 instance must have null id");
        }
        person.setId(sequenceGenerator.nextVal());
        personMap.put(person.getId(), person);
        return person;
    }

    public PersonQ3 findById(Integer id) {
        return personMap.get(id);
    }

    public boolean setSequenceGenerator(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
        return true;
    }
}
