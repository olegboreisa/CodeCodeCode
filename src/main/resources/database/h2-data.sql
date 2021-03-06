INSERT INTO USER (id, registration_date, username, password, country, phone_number) VALUES
(1, CURRENT_DATE, 'admin', '123', 'Lithuania', '+37064616189'),
(2, CURRENT_DATE, 'kepsnys', '123', 'Lithuania', '+37064616189'),
(3, CURRENT_DATE, 'edvin', '123', 'Lithuania', '+37064616189'),
(4, CURRENT_DATE, 'audrius', '123', 'Lithuania', '+37064616189'),
(5, CURRENT_DATE, 'ieva', '123', 'Lithuania', '+37064616189');

INSERT INTO BLOG (id, posted_date, header, main_text, likes, user_id) VALUES
    (1, '2013-09-29',
     'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque hendrerit',
     'One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections. The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked. "What''s happened to me?" he thought. It wasn''t a dream. His room, a proper human room although a little too small, lay peacefully between its four familiar walls. A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture that he had recently cut out of an illustrated magazine and housed in a nice, gilded frame. It showed a lady fitted out with a fur hat and fur boa who sat upright, raising a heavy fur muff that covered the whole of her lower arm towards the viewer. Gregor then turned to look out the window at the dull weather. Drops', 10, 1);

INSERT INTO BLOG (id, posted_date, header, main_text, likes, user_id) VALUES
    (2, '2020-12-11',
    'Consectetur adipiscing elit. Maecenas efficitur',
     'A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now. When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among the tall grass by the trickling stream; and, as I lie close to the earth, a thousand unknown plants are noticed by me: when I hear the buzz of the little world among the stalks, and grow familiar with the countless indescribable forms of the insects and flies, then I feel the presence of the Almighty, who formed us in his own image, and the breath', 0, 3);

INSERT INTO BLOG (id, posted_date, header, main_text, likes, user_id) VALUES
    (3, '2016-02-11',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
     'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek. texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then.', 15, 1);


INSERT INTO BLOG (id, posted_date, header, main_text, likes, user_id) VALUES
    (4, '2001-01-01',
     'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
 'The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary. The languages only differ in their grammar, their pronunciation and their most common words. Everyone realizes why a new common language would be desirable: one could refuse to pay expensive translators. To achieve this, it would be necessary to have uniform grammar, pronunciation and more common words. If several languages coalesce, the grammar of the resulting language is more simple and regular than that of the individual languages. The new common language will be more simple and regular than the existing European languages. It will be as simple as Occidental; in fact, it will be Occidental. To an English person, it will seem like simplified English, as a skeptical Cambridge friend of mine told me what Occidental is.The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary. The languages only differ in their grammar, their pronunciation and their most common words. Everyone realizes why a new common language would be desirable: one could refuse to pay expensive translators.', 1231, 2);

INSERT INTO BLOG (id, posted_date, header, main_text, likes, user_id) VALUES
    (5, '1999-02-16',
     'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
 'But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure? On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee.', 0, 2);

INSERT INTO COMMENT (id, posted_date, name, second_name, text, blog_id) VALUES
       (1, '1994-10-22', 'Oleg', 'Boreisa', 'Nicely Writen!', 1),
       (2, '2002-06-11', 'Tautvydas', 'Strolia', 'Hate!', 1),
       (3, '2020-12-12', 'Donatas', 'Viazevicius', 'I would like to hear more information!', 1),
       (4, '1614-01-01', 'Edvin', 'Kupsas', 'I did not read and I still rated it as a disinformation 5G RULES!', 2);

INSERT INTO ROLE (id, role) VALUES
        (1, 'Admin'),
        (2, 'User');

INSERT INTO USER_ROLE (user_id, role_id) VALUES
        (1, 1),
        (2, 1),
        (3, 1),
        (4, 1),
        (5, 1);