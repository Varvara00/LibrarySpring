package varvara.com.stringmvc.util;


//@Component
//public class PersonValidator implements Validator {
//    private final PersonDAO personDAO;
//
//    @Autowired
//    public PersonValidator(PersonDAO personDAO) {
//        this.personDAO = personDAO;
//    }
//
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return Person.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        Person person = (Person) o;
//
//        if (personDAO.show(person.getId()).isPresent()) {
//            errors.rejectValue("id", "", "");
//        }
//
//    }
//}
