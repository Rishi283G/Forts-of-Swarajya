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
 * Database seeder for development environment
 * Only runs in 'dev' profile to prevent accidental data seeding in production
 */
@Component
@Profile("dev") // Only run in development mode
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
                    "/image/r1.jpg",
                    Arrays.asList("/image/r1.jpg", "/image/r2.jpg", "/image/r3.jpg", "/image/r4.jpg", "/image/r5.jpg", "/image/r6.jpg", "/image/r7.jpg", "/image/r8.jpg"));

            // 2. Shivneri
            createFort("Shivneri Fort", "Pune District", "Hill Fort",
                    "Shivneri Fort is a 17th-century military fortification located near Junnar in Pune district in Maharashtra, India. " +
                            "It is the birthplace of Chhatrapati Shivaji Maharaj, the founder of the Maratha Empire. " +
                            "The fort has seven gates (Maha Darwaja, Pir Darwaja, etc.) and a temple of Goddess Shivai.",
                    "/image/shivneri.jpg",
                    Arrays.asList("/image/shiv1.jpg", "/image/shiv2.jpg", "/image/shiv3.jpg", "/image/shiv4.jpg", "/image/shiv5.jpg", "/image/shiv6.jpg", "/image/shiv7.jpg", "/image/shiv8.jpg"));

            // 3. Pratapgad
            createFort("Pratapgad Fort", "Satara District", "Hill Fort",
                    "Pratapgad acts as a popular tourist destination. The fort is located 24 kilometres from the hill station of Mahabaleshwar. " +
                            "The battle of Pratapgad between Shivaji Maharaj and Afzal Khan was fought below the ramparts of this fort on November 10, 1659. " +
                            "It stands 1080 metres (3540 ft) above sea level.",
                    "/image/pratapgad.jpg",
                    Arrays.asList("/image/pratapgad1.jpg", "/image/pratapgad2.jpg", "/image/pratapgad3.jpg", "/image/pratapgad4.jpg", "/image/pratapgad5.jpg", "/image/pratapgad6.jpg", "/image/pratapgad7.jpg", "/image/pratapgad8.jpg"));

            // 4. Sindhudurg
            createFort("Sindhudurg Fort", "Sindhudurg District", "Sea Fort",
                    "Sindhudurg is a historical fort that occupies an islet in the Arabian Sea, just off the coast of Maharashtra in Western India. " +
                            "The fortress lies on the shore of Malvan town of Sindhudurg District in the Konkan region of Maharashtra. " +
                            "Built by Shivaji Maharaj, it is a testament to the Maratha naval power.",
                    "/image/sindhdurg.jpg",
                    Arrays.asList("/image/s1.jpg", "/image/s2.jpg", "/image/s3.jpg", "/image/s4.jpg", "/image/s5.jpg", "/image/s6.jpg", "/image/s7.jpg", "/image/s8.jpg"));

            // 5. Torana
            createFort("Torna Fort", "Pune District", "Hill Fort",
                    "Torna Fort, also known as Prachandagad, is a large fort located in Pune district, Maharashtra, India. " +
                            "It is historically significant because it was the first fort captured by Shivaji Maharaj in 1646, at the age of 16. " +
                            "The hill has an elevation of 1,403 metres (4,603 ft) above sea level, making it the highest hill-fort in the district.",
                    "/image/torana.jpg",
                    Arrays.asList("/image/torana1.jpg", "/image/torana2.jpg", "/image/torana3.jpg", "/image/torana4.jpg", "/image/torana5.jpg", "/image/torana6.jpg", "/image/torana8.jpg")); // missing 7

            // 6. Harihar
            createFort("Harihar Fort", "Nashik District", "Hill Fort",
                    "Harihar Fort / Harshagad is a fort located 40 km from Nashik City, 48 km from Igatpuri, 40 km from Ghoti in Nashik district, of Maharashtra. " +
                            "It is an important fort in Nashik district, and was constructed to look upon the trade route through Gonda Ghat. " +
                            "It is famous for its peculiar rock-cut steps.",
                    "/image/harihar.jpg",
                    Arrays.asList("/image/harihar1.jpg", "/image/harihar2.jpg", "/image/harihar3.jpg", "/image/harihar4.jpg", "/image/harihar5.jpg", "/image/harihar6.jpg", "/image/harihar7.jpg", "/image/harihar8.jpg"));

            // 7. Purandar
            createFort("Purandar Fort", "Pune District", "Hill Fort",
                    "Purandar Fort is known as the birthplace of Sambhaji Maharaj, the son of Chhatrapati Shivaji Maharaj. " +
                            "The fort is repeatedly mentioned in the rising of Shivaji Maharaj against the Adil Shahi Bijapur Sultanate and the Mughals. " +
                            "It stands at 4,472 ft above sea level in the Western Ghats.",
                    "/image/purandar.jpg",
                    Arrays.asList("/image/pur1.jpg", "/image/pur2.jpg", "/image/pur3.jpg", "/image/pur4.jpg", "/image/pur5.jpg", "/image/pur6.jpg", "/image/pur7.jpg", "/image/pur8.jpg"));

            // 8. Rajgad
            createFort("Rajgad Fort", "Pune District", "Hill Fort",
                    "Rajgad (ruling fort) is a hill fort situated in the Pune district of Maharashtra, India. " +
                            "Formerly known as Murumdev, the fort was the capital of the Maratha Empire under the rule of Chhatrapati Shivaji Maharaj for almost 26 years, " +
                            "after which the capital was moved to the Raigad Fort.",
                    "/image/rajgad.jpg",
                    Arrays.asList("/image/raj1.jpg", "/image/raj2.jpg", "/image/raj3.jpg", "/image/raj4.jpg", "/image/raj5.jpg", "/image/raj6.jpg", "/image/raj7.jpg"));

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
