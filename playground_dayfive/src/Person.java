 public class Person {
     private String FirstName;
     private String LastName;
     private String Email;

     public Person() {
     }

     private String City;

     public Person(String firstName, String lastName, String email, String city) {
         FirstName = firstName;
         LastName = lastName;
         Email = email;
         City = city;
     }

     public String getFirstName() {
         return FirstName;
     }

     public String getLastName() {
         return LastName;
     }

     public String getEmail() {
         return Email;
     }

     public String getCity() {
         return City;
     }
 }
