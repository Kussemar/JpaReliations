import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        // Sætter databasen op til relations, så den kan kører
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("relations");
        Person jens = new Person("Jens");
        Person christian = new Person("Christian");

        Phone p1 = new Phone("111-222-33");
        Phone p2 = new Phone("999-222-33");

        jens.setPhone(p1);
        christian.setPhone(p2);



            try(var em = emf.createEntityManager()){
                em.getTransaction().begin();
                em.persist(jens);
                em.persist(christian);
//                em.persist(p1);
//                em.persist(p2);

                em.getTransaction().commit();
            }



        try (var em = emf.createEntityManager()) {
            Person person = em.find(Person.class, 2);
            System.out.println(person.getPhone().getNumber());

            Phone phone = em.find(Phone.class, 2);
            System.out.println(phone.getPerson().getName());
        }
    }

}