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
                    "Raigad is a hill fort situated in the Mahad, Raigad district of Maharashtra, India. It is one of the strongest fortresses on the Deccan Plateau.",
                    "Raigad was the capital of the Maratha Empire under Chhatrapati Shivaji Maharaj. It is located in the Sahyadri mountain range. The fort was built by Hiroji Indulkar under the supervision of Shivaji Maharaj. The coronation of Shivaji Maharaj took place here in 1674.",
                    "/images/r1.jpg",
                    "r1.jpg,r2.jpg,r3.jpg,r4.jpg,r5.jpg,r6.jpg,r7.jpg,r8.jpg",
                    Arrays.asList("/images/r1.jpg", "/images/r2.jpg", "/images/r3.jpg", "/images/r4.jpg", "/images/r5.jpg", "/images/r6.jpg", "/images/r7.jpg", "/images/r8.jpg"));

            // 2. Shivneri
            createFort("Shivneri Fort", "Pune District", "Hill Fort",
                    "Shivneri Fort is a 17th-century military fortification located near Junnar in Pune district in Maharashtra, India.",
                    "Shivneri is the birthplace of Chhatrapati Shivaji Maharaj, born on February 19, 1630. The fort has seven large gates and a small temple of Goddess Shivai after whom Shivaji was named. It is an invincible fort with steep rocks on all sides.",
                    "/images/shivneri.jpg",
                    "shiv1.jpg,shiv2.jpg,shiv3.jpg,shiv4.jpg,shiv5.jpg,shiv6.jpg,shiv7.jpg,shiv8.jpg",
                    Arrays.asList("/images/shiv1.jpg", "/images/shiv2.jpg", "/images/shiv3.jpg", "/images/shiv4.jpg", "/images/shiv5.jpg", "/images/shiv6.jpg", "/images/shiv7.jpg", "/images/shiv8.jpg"));

            // 3. Pratapgad
            createFort("Pratapgad Fort", "Satara District", "Hill Fort",
                    "Pratapgad acts as a popular tourist destination. The fort is located 24 kilometres from the hill station of Mahabaleshwar.",
                    "The fort is famous for the historic Battle of Pratapgad in 1659 between Shivaji Maharaj and Afzal Khan. Shivaji Maharaj killed the mighty Afzal Khan here, marking a significant victory for the Marathas. It offers a panoramic view of the Konkan coast.",
                    "/images/pratapgad.jpg",
                    "pratapgad1.jpg,pratapgad2.jpg,pratapgad3.jpg,pratapgad4.jpg,pratapgad5.jpg,pratapgad6.jpg,pratapgad7.jpg,pratapgad8.jpg",
                    Arrays.asList("/images/pratapgad1.jpg", "/images/pratapgad2.jpg", "/images/pratapgad3.jpg", "/images/pratapgad4.jpg", "/images/pratapgad5.jpg", "/images/pratapgad6.jpg", "/images/pratapgad7.jpg", "/images/pratapgad8.jpg"));

            // 4. Sindhudurg
            createFort("Sindhudurg Fort", "Sindhudurg District", "Sea Fort",
                    "Sindhudurg is a historical fort that occupies an islet in the Arabian Sea, just off the coast of Maharashtra in Western India.",
                    "Constructed by Shivaji Maharaj in 1664, this sea fort was built to protect the Maratha coast from the Siddis, Portuguese, and British. It is spread over 48 acres and is surrounded by the vast Arabian Sea. It is a marvel of naval architecture.",
                    "/images/sindhdurg.jpg",
                    "s1.jpg,s2.jpg,s3.jpg,s4.jpg,s5.jpg,s6.jpg,s7.jpg,s8.jpg",
                    Arrays.asList("/images/s1.jpg", "/images/s2.jpg", "/images/s3.jpg", "/images/s4.jpg", "/images/s5.jpg", "/images/s6.jpg", "/images/s7.jpg", "/images/s8.jpg"));

            // 5. Torana
            createFort("Torna Fort", "Pune District", "Hill Fort",
                    "Torna Fort, also known as Prachandagad, is a large fort located in Pune district, Maharashtra, India.",
                    "Torna was the first fort captured by Shivaji Maharaj in 1646 at the age of 16, which marked the beginning of his quest for Swarajya. It is one of the highest forts in the region and is known for its massive size and difficult terrain.",
                    "/images/torana.jpg",
                    "torana1.jpg,torana2.jpg,torana3.jpg,torana4.jpg,torana5.jpg,torana6.jpg,torana8.jpg",
                    Arrays.asList("/images/torana1.jpg", "/images/torana2.jpg", "/images/torana3.jpg", "/images/torana4.jpg", "/images/torana5.jpg", "/images/torana6.jpg", "/images/torana8.jpg"));

            // 6. Harihar
            createFort("Harihar Fort", "Nashik District", "Hill Fort",
                    "Harihar Fort / Harshagad is a fort located 40 km from Nashik City, 48 km from Igatpuri, 40 km from Ghoti in Nashik district, of Maharashtra.",
                    "Famous for its near-vertical rock-cut steps, Harihar fort is a trekker's paradise. It was constructed to keep a watch on the trade route through Gonda Ghat. The steps are carved at an angle of almost 80 degrees, making it a unique climbing experience.",
                    "/images/harihar.jpg",
                    "harihar1.jpg,harihar2.jpg,harihar3.jpg,harihar4.jpg,harihar5.jpg,harihar6.jpg,harihar7.jpg,harihar8.jpg",
                    Arrays.asList("/images/harihar1.jpg", "/images/harihar2.jpg", "/images/harihar3.jpg", "/images/harihar4.jpg", "/images/harihar5.jpg", "/images/harihar6.jpg", "/images/harihar7.jpg", "/images/harihar8.jpg"));

            // 7. Purandar
            createFort("Purandar Fort", "Pune District", "Hill Fort",
                    "Purandar Fort is known as the birthplace of Sambhaji Maharaj, the son of Chhatrapati Shivaji Maharaj.",
                    "Purandar has two distinct levels - the lower Balekilla and the upper Machi. It played a crucial role in many conflicts and was the site of the Treaty of Purandar in 1665 between Shivaji Maharaj and Jai Singh I. It stands as a majestic sentinel in the Western Ghats.",
                    "/images/purandar.jpg",
                    "pur1.jpg,pur2.jpg,pur3.jpg,pur4.jpg,pur5.jpg,pur6.jpg,pur7.jpg,pur8.jpg",
                    Arrays.asList("/images/pur1.jpg", "/images/pur2.jpg", "/images/pur3.jpg", "/images/pur4.jpg", "/images/pur5.jpg", "/images/pur6.jpg", "/images/pur7.jpg", "/images/pur8.jpg"));

            // 8. Rajgad
            createFort("Rajgad Fort", "Pune District", "Hill Fort",
                    "Rajgad (ruling fort) is a hill fort situated in the Pune district of Maharashtra, India.",
                    "Rajgad was the first capital of the Maratha Empire under Shivaji Maharaj for 26 years. It is known for its architectural splendor, especially the Padmavati Machi, Sanjeevani Machi, and Suvela Machi. It is often referred to as the 'King of Forts'.",
                    "/images/rajgad.jpg",
                    "raj1.jpg,raj2.jpg,raj3.jpg,raj4.jpg,raj5.jpg,raj6.jpg,raj7.jpg",
                    Arrays.asList("/images/raj1.jpg", "/images/raj2.jpg", "/images/raj3.jpg", "/images/raj4.jpg", "/images/raj5.jpg", "/images/raj6.jpg", "/images/raj7.jpg"));

            logger.info("Seeding complete!");
        }
    }

    private void createFort(String name, String location, String type, String description, String history, String galleryImages, String mainImage, List<String> imagePaths) {
        Fort fort = new Fort();
        fort.setName(name);
        fort.setLocation(location);
        fort.setType(type);
        fort.setDescription(description);
        fort.setHistory(history);
        fort.setGalleryImages(galleryImages);
        fort.setMainImage(mainImage);

        List<FortImage> images = new ArrayList<>();
        for (String path : imagePaths) {
            images.add(new FortImage(fort, path));
        }
        fort.setImages(images);

        fortRepository.save(fort);
    }
}
