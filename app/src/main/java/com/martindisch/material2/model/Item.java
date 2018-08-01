package com.martindisch.material2.model;

import com.martindisch.material2.R;

import java.util.Random;

public class Item {

    private static final String[] TEXTS = {
            "Herman",
            "Ronan",
            "Tarik",
            "Chastity",
            "Christopher",
            "Daquan",
            "Otto",
            "Cailin",
            "Damon",
            "Phillip",
            "Theodore",
            "Wynne",
            "Jorden",
            "Lacey",
            "Whitney",
            "Reece",
            "Chase",
            "Sean",
            "Lenore",
            "Tana",
            "Briar",
            "Ila",
            "Berk",
            "Maris",
            "Cailin",
            "Ivan",
            "Reese",
            "Alec",
            "Honorato",
            "Judah",
            "Georgia",
            "Jakeem",
            "Britanney",
            "Burke",
            "Prescott",
            "Yuli",
            "Travis",
            "Irene",
            "Madeline",
            "Nathaniel",
            "Camilla",
            "Olympia",
            "Paloma",
            "Rae",
            "Ulla",
            "Leroy",
            "Nichole",
            "Phillip",
            "Warren",
            "Cameron",
            "Aileen",
            "Anika",
            "Jessamine",
            "Tanek",
            "Ian",
            "Micah",
            "William",
            "Xenos",
            "Juliet",
            "Jane",
            "Latifah",
            "Emerald",
            "Jade",
            "Alexander",
            "Nasim",
            "Jolene",
            "Clarke",
            "Dara",
            "Grace",
            "Sybill",
            "Alvin",
            "Brandon",
            "Slade",
            "Debra",
            "Kelsie",
            "Burton",
            "Conan",
            "Norman",
            "Karyn",
            "Marny",
            "Dorothy",
            "Alvin",
            "Amanda",
            "Naida",
            "Aidan",
            "Adele",
            "Reece",
            "Porter",
            "Libby",
            "Germane",
            "Tanner",
            "Thor",
            "Linda",
            "Daniel",
            "Kato",
            "Griffith",
            "Jessamine",
            "Chiquita",
            "Emi",
            "Warren"
    };

    private static final int IMAGES[] = {
            R.drawable.ic_commute,
            R.drawable.ic_favorite,
            R.drawable.ic_person,
            R.drawable.ic_schedule,
            R.drawable.ic_view_list
    };

    private String text;
    private int image;
    private int id;

    public Item() {
        text = TEXTS[new Random().nextInt(TEXTS.length)];
        image = IMAGES[new Random().nextInt(IMAGES.length)];
        id = new Random().nextInt();
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
}
