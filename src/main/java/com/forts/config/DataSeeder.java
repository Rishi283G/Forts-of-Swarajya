package com.forts.config;

import com.forts.model.Fort;
import com.forts.model.FortImage;
import com.forts.repository.FortRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Database seeder for initializing fort data.
 * Runs on application startup and seeds the database if the 'forts' table is empty.
 * Production-safe as it includes a count check to avoid duplicates.
 */
@Component
public class DataSeeder implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataSeeder.class);

    @Autowired
    private FortRepository fortRepository;

    @Override
    public void run(String... args) throws Exception {
        if (fortRepository.count() == 0) {
            logger.info("Seeding database with forts...");


            // 1. Raigad
            createFort("Raigad Fort", "Raigad District", "Hill Fort",
                    "Raigad is a hill fort situated in the Mahad, Raigad district of Maharashtra, India. It is one of the strongest fortresses on the Deccan Plateau. " +
                            "Many constructions and structures on Raigad were built by Chhatrapati Shivaji Maharaj when he made it his capital in 1674 upon being crowned King of the Maratha Kingdom. " +
                            "The fort rises 820 metres (2,700 ft) above the sea level in the Sahyadri mountain range. There are approximately 1737 steps leading to the fort.",
                    "/images/r1.jpg",
                    Arrays.asList("/images/r1.jpg", "/images/r2.jpg", "/images/r3.jpg", "/images/r4.jpg", "/images/r5.jpg", "/images/r6.jpg", "/images/r7.jpg", "/images/r8.jpg"));

            // 2. Shivneri
            createFort("Shivneri Fort", "Pune District", "Hill Fort",
                    "Shivneri Fort is a 17th-century military fortification located near Junnar in Pune district in Maharashtra, India. " +
                            "It is the birthplace of Chhatrapati Shivaji Maharaj, the founder of the Maratha Empire. " +
                            "The fort has seven gates (Maha Darwaja, Pir Darwaja, etc.) and a temple of Goddess Shivai.",
                    "/images/shivneri.jpg",
                    Arrays.asList("/images/shiv1.jpg", "/images/shiv2.jpg", "/images/shiv3.jpg", "/images/shiv4.jpg", "/images/shiv5.jpg", "/images/shiv6.jpg", "/images/shiv7.jpg", "/images/shiv8.jpg"));

            // 3. Pratapgad
            createFort("Pratapgad Fort", "Satara District", "Hill Fort",
                    "Pratapgad acts as a popular tourist destination. The fort is located 24 kilometres from the hill station of Mahabaleshwar. " +
                            "The battle of Pratapgad between Shivaji Maharaj and Afzal Khan was fought below the ramparts of this fort on November 10, 1659. " +
                            "It stands 1080 metres (3540 ft) above sea level.",
                    "/images/pratapgad.jpg",
                    Arrays.asList("/images/pratapgad1.jpg", "/images/pratapgad2.jpg", "/images/pratapgad3.jpg", "/images/pratapgad4.jpg", "/images/pratapgad5.jpg", "/images/pratapgad6.jpg", "/images/pratapgad7.jpg", "/images/pratapgad8.jpg"));

            // 4. Sindhudurg
            createFort("Sindhudurg Fort", "Sindhudurg District", "Sea Fort",
                    "Sindhudurg is a historical fort that occupies an islet in the Arabian Sea, just off the coast of Maharashtra in Western India. " +
                            "The fortress lies on the shore of Malvan town of Sindhudurg District in the Konkan region of Maharashtra. " +
                            "Built by Shivaji Maharaj, it is a testament to the Maratha naval power.",
                    "/images/sindhdurg.jpg",
                    Arrays.asList("/images/s1.jpg", "/images/s2.jpg", "/images/s3.jpg", "/images/s4.jpg", "/images/s5.jpg", "/images/s6.jpg", "/images/s7.jpg", "/images/s8.jpg"));

            // 5. Torana
            createFort("Torna Fort", "Pune District", "Hill Fort",
                    "Torna Fort, also known as Prachandagad, is a large fort located in Pune district, Maharashtra, India. " +
                            "It is historically significant because it was the first fort captured by Shivaji Maharaj in 1646, at the age of 16. " +
                            "The hill has an elevation of 1,403 metres (4,603 ft) above sea level, making it the highest hill-fort in the district.",
                    "/images/torana.jpg",
                    Arrays.asList("/images/torana1.jpg", "/images/torana2.jpg", "/images/torana3.jpg", "/images/torana4.jpg", "/images/torana5.jpg", "/images/torana6.jpg", "/images/torana8.jpg")); // missing 7

            // 6. Harihar
            createFort("Harihar Fort", "Nashik District", "Hill Fort",
                    "Harihar Fort / Harshagad is a fort located 40 km from Nashik City, 48 km from Igatpuri, 40 km from Ghoti in Nashik district, of Maharashtra. " +
                            "It is an important fort in Nashik district, and was constructed to look upon the trade route through Gonda Ghat. " +
                            "It is famous for its peculiar rock-cut steps.",
                    "/images/harihar.jpg",
                    Arrays.asList("/images/harihar1.jpg", "/images/harihar2.jpg", "/images/harihar3.jpg", "/images/harihar4.jpg", "/images/harihar5.jpg", "/images/harihar6.jpg", "/images/harihar7.jpg", "/images/harihar8.jpg"));

            // 7. Purandar
            createFort("Purandar Fort", "Pune District", "Hill Fort",
                    "Purandar Fort is known as the birthplace of Sambhaji Maharaj, the son of Chhatrapati Shivaji Maharaj. " +
                            "The fort is repeatedly mentioned in the rising of Shivaji Maharaj against the Adil Shahi Bijapur Sultanate and the Mughals. " +
                            "It stands at 4,472 ft above sea level in the Western Ghats.",
                    "/images/purandar.jpg",
                    Arrays.asList("/images/pur1.jpg", "/images/pur2.jpg", "/images/pur3.jpg", "/images/pur4.jpg", "/images/pur5.jpg", "/images/pur6.jpg", "/images/pur7.jpg", "/images/pur8.jpg"));

            // 8. Rajgad
            createFort("Rajgad Fort", "Pune District", "Hill Fort",
                    "Rajgad (ruling fort) is a hill fort situated in the Pune district of Maharashtra, India. " +
                            "Formerly known as Murumdev, the fort was the capital of the Maratha Empire under the rule of Chhatrapati Shivaji Maharaj for almost 26 years, " +
                            "after which the capital was moved to the Raigad Fort.",
                    "/images/rajgad.jpg",
                    Arrays.asList("/images/raj1.jpg", "/images/raj2.jpg", "/images/raj3.jpg", "/images/raj4.jpg", "/images/raj5.jpg", "/images/raj6.jpg", "/images/raj7.jpg"));

            logger.info("Seeding complete!");
        }
    }

    private void createFort(String name, String location, String type, String description, String mainImage, List<String> imagePaths) {
        Fort fort = new Fort();
        fort.setName(name);
        fort.setLocation(location);
        fort.setType(type);
        fort.setDescription(description);
        fort.setMainImage(mainImage);

        List<FortImage> images = new ArrayList<>();
        for (String path : imagePaths) {
            images.add(new FortImage(fort, path));
        }
        fort.setImages(images);

        fortRepository.save(fort);
    }
}
