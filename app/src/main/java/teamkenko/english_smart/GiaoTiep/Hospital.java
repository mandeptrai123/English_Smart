package teamkenko.english_smart.GiaoTiep;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import teamkenko.english_smart.R;

public class Hospital extends AppCompatActivity {
    VideoView video;
 MediaController mediaController;
    TextView trans;
  TextView title_video;
    CountDownTimer countDownTimer ;
    int vitri=0;
    int [][] time={{12,46,70,120,143,183,224},{5,39,72,96,143,176,205,242},{8,30,81,108,124,149,174,212,244,265}};
    String [] title={"Who decides what art means ?","Why do cats act so weird","The science of skin color"};
    String [][] text={{"Imagine you and a friend are strolling through an art exhibit and a striking painting catches your eye. The vibrant red appears to you as a symbol of love, but your friend is convinced it's a symbol of war. And where you see stars in a romantic sky, your friend interprets global warming-inducing pollutants. To settle the debate, you turn to the internet, where you read that the painting is a replica of the artist's first-grade art project: Red was her favorite color and the silver dots are fairies.",
            "You now know the exact intentions that led to the creation of this work. Are you wrong to have enjoyed it as something the artist didn’t intend? Do you enjoy it less now that you know the truth? Just how much should the artist's intention affect your interpretation of the painting? It's a question that's been tossed around by philosophers and art critics for decades, with no consensus in sight.",
            "In the mid-20th century, literary critic W.K. Wimsatt and philosopher Monroe Beardsley argued that artistic intention was irrelevant. They called this the Intentional Fallacy: the belief that valuing an artist's intentions was misguided. Their argument was twofold: First, the artists we study are no longer living, never recorded their intentions, or are simply unavailable to answer questions about their work. Second, even if there were a bounty of relevant information, Wimsatt and Beardsley believed it would distract us from the qualities of the work itself. They compared art to a dessert: When you taste a pudding, the chef's intentions don't affect whether you enjoy its flavor or texture. All that matters, they said, is that the pudding \"works.\"",
            "Of course, what \"works\" for one person might not \"work\" for another. And since different interpretations appeal to different people, the silver dots in our painting could be reasonably interpreted as fairies, stars, or pollutants. By Wimsatt and Beardsley's logic, the artist's interpretation of her own work would just be one among many equally acceptable possibilities.",
            "If you find this problematic, you might be more in line with Steven Knapp and Walter Benn Michaels, two literary theorists who rejected the Intentional Fallacy. They argued that an artist's intended meaning was not just one possible interpretation, but the only possible interpretation. For example, suppose you're walking along a beach and come across a series of marks in the sand that spell out a verse of poetry. Knapp and Michaels believed the poem would lose all meaning if you discovered these marks were not the work of a human being, but an odd coincidence produced by the waves. They believed an intentional creator is what makes the poem subject to understanding at all.",
            "Other thinkers advocate for a middle ground, suggesting that intention is just one piece in a larger puzzle. Contemporary philosopher Noel Carroll took this stance, arguing that an artist's intentions are relevant to their audience the same way a speaker's intentions are relevant to the person they’re engaging in conversation. To understand how intentions function in conversation, Carroll said to imagine someone holding a cigarette and asking for a match. You respond by handing them a lighter, gathering that their motivation is to light their cigarette. The words they used to ask the question are important, but the intentions behind the question dictate your understanding and ultimately, your response.",
            "So which end of this spectrum do you lean towards? Do you, like Wimsatt and Beardsley, believe that when it comes to art, the proof should be in the pudding? Or do you think that an artist's plans and motivations for their work affect its meaning? Artistic interpretation is a complex web that will probably never offer a definitive answer."},


{"Why do cats do that? They're cute, they're lovable, and judging by the 26 billions views of over 2 million YouTube videos of them pouncing, bouncing, climbing, cramming, stalking, clawing, chattering, and purring, one thing is certain: cats are very entertaining. These somewhat strange feline behaviors, both amusing and baffling, leave many of us asking, \"Why do cats do that?\"",
"Throughout time, cats were simultaneously solitary predators of smaller animals and prey for larger carnivores. As both predator and prey, survival of their species depended on crucial instinctual behaviors which we still observe in wild and domestic cats today. While the feline actions of your house cat Grizmo might seem perplexing, in the wild, these same behaviors, naturally bred into cats for millions of years, would make Grizmo a super cat.",
"Enabled by their unique muscular structure and keen balancing abilities, cats climbed to high vantage points to survey their territory and spot prey in the wild. Grizmo doesn't need these particular skills to find and hunt down dinner in her food bowl today, but instinctually, viewing the living room from the top of the bookcase is exactly what she has evolved to do.",
"As wild predators, cats are opportunistic and hunt whenever prey is available. Since most cat prey are small, cats in the wild needed to eat many times each day, and use a stalk, pounce, kill, eat strategy to stay fed. This is why Grismo prefers to chase and pounce on little toys and eat small meals over the course of the day and night. Also, small prey tend to hide in tiny spaces in their natural environments, so one explanation for Grizmo's propensity to reach into containers and openings is that she is compelled by the same curiosity that helped ensure the continuation of her species for millions of years before.",
"In the wild, cats needed sharp claws for climbing, hunting, and self-defense. Sharpening their claws on nearby surfaces kept them conditioned and ready, helped stretch their back and leg muscles, and relieve some stress, too. So, it's not that Grizmo hates your couch, chair, ottoman, pillows, curtains, and everything else you put in her environment. She's ripping these things to shreds and keeping her claws in tip-top shape because this is exactly what her ancestors did in order to survive.",
"As animals that were preyed upon, cats evolved to not get caught, and in the wild, the cats that were the best at avoiding predators thrived. So at your house today, Grizmo is an expert at squeezing into small spaces and seeking out and hiding in unconventional spots. It also explains why she prefers a clean and odor-free litter box. That's less likely to give away her location to any predators that may be sniffing around nearby.",
"Considering everything we do know about cats, it seems that one of their most predominate behaviors is still one of the most mysterious. Cats may purr for any number of reasons, such as happiness, stress, and hunger. But curiously, the frequency of their purrs, between 25 and 150 hertz, is within a range that can promote tissue regeneration. So while her purring makes Grizmo an excellent nap companion, it is also possible that her purr is healing her muscles and bones, and maybe even yours, too.",
"They developed through time as both solitary predators that hunted and killed to eat, and stealthy prey that hid and escaped to survive. So cats today retain many of the same instincts that allowed them to thrive in the wild for millions of years. This explains some of their seemingly strange behaviors. To them, our homes are their jungles. But if this is the case, in our own cat's eyes, who are we? Big, dumb, hairless cats competing with them for resources? Terribly stupid predators they're able to outsmart everyday? Or maybe they think we're the prey."},

            {"When ultraviolet sunlight hits our skin, it affects each of us a little differently. Depending on skin color, it will take only minutes of exposure to turn one person beetroot-pink, while another requires hours to experience the slightest change. So what's to account for that difference and how did our skin come to take on so many different hues to begin with?",
            "Whatever the color, our skin tells an epic tale of human intrepidness and adaptability, revealing its variance to be a function of biology. It all centers around melanin, the pigment that gives skin and hair its color. This ingredient comes from skin cells called melanocytes and takes two basic forms. There's eumelanin, which gives rise to a range of brown skin tones, as well as black, brown, and blond hair, and pheomelanin, which causes the reddish browns of freckles and red hair. But humans weren't always like this. Our varying skin tones were formed by an evolutionary process driven by the Sun. In began some 50,000 years ago when our ancestors migrated north from Africa and into Europe and Asia.",
            "These ancient humans lived between the Equator and the Tropic of Capricorn, a region saturated by the Sun's UV-carrying rays. When skin is exposed to UV for long periods of time, the UV light damages the DNA within our cells, and skin starts to burn. If that damage is severe enough, the cells mutations can lead to melanoma, a deadly cancer that forms in the skin's melanocytes.",
            "Sunscreen as we know it today didn't exist 50,000 years ago. So how did our ancestors cope with this onslaught of UV? The key to survival lay in their own personal sunscreen manufactured beneath the skin: melanin.",
            "The type and amount of melanin in your skin determines whether you'll be more or less protected from the sun. This comes down to the skin's response as sunlight strikes it. When it's exposed to UV light, that triggers special light-sensitive receptors called rhodopsin, which stimulate the production of melanin to shield cells from damage. For light-skin people, that extra melanin darkens their skin and produces a tan.",
            "Over the course of generations, humans living at the Sun-saturated latitudes in Africa adapted to have a higher melanin production threshold and more eumelanin, giving skin a darker tone. This built-in sun shield helped protect them from melanoma, likely making them evolutionarily fitter and capable of passing this useful trait on to new generations.",
            "But soon, some of our Sun-adapted ancestors migrated northward out of the tropical zone, spreading far and wide across the Earth. The further north they traveled, the less direct sunshine they saw. This was a problem because although UV light can damage skin, it also has an important parallel benefit. UV helps our bodies produce vitamin D, an ingredient that strengthens bones and lets us absorb vital minerals, like calcium, iron, magnesium, phosphate, and zinc. Without it, humans experience serious fatigue and weakened bones that can cause a condition known as rickets.",
            "For humans whose dark skin effectively blocked whatever sunlight there was, vitamin D deficiency would have posed a serious threat in the north. But some of them happened to produce less melanin. They were exposed to small enough amounts of light that melanoma was less likely, and their lighter skin better absorbed the UV light. So they benefited from vitamin D, developed strong bones, and survived well enough to produce healthy offspring. Over many generations of selection, skin color in those regions gradually lightened.",
            "As a result of our ancestor's adaptability, today the planet is full of people with a vast palette of skin colors, typically, darker eumelanin-rich skin in the hot, sunny band around the Equator, and increasingly lighter pheomelanin-rich skin shades fanning outwards as the sunshine dwindles.",
            "Therefore, skin color is little more than an adaptive trait for living on a rock that orbits the Sun. It may absorb light, but it certainly does not reflect character."}};
    String [] url={"https://pc.tedcdn.com/talk/stream/2018E/Blank/HayleyLevitt_AuthorialIntent_2018E-320k.mp4?dnt",
            "https://pc.tedcdn.com/talk/stream/2015E/Blank/TonyBuffington_Cats_2015E-320k.mp4?dnt",
    "https://pc.tedcdn.com/talk/stream/2015E/Blank/AngelaKoineFlynn_SkinColor_2015E-320k.mp4?dnt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        video = (VideoView) findViewById(R.id.video_giaotiep);
        trans = (TextView)findViewById(R.id.translate);
        title_video = (TextView) findViewById(R.id.title_video);
        mediaController = new MediaController(this);


        video.requestFocus();
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);
        video.start();
        /*
        countDownTimer = new CountDownTimer(1000000000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                if((video.getCurrentPosition()/1000)==time[Kind_Art.kind][vitri])
                {
                   trans.setText(text[Kind_Art.kind][vitri]);
                   vitri++;
                }

            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();




    }
    public  void getPosition(View view)
    {
        Toasty.info(getApplicationContext(),video.getCurrentPosition()/1000+"",1000).show();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Hospital.this, Menu_GiaoTiep.class);
        startActivity(intent);
        finish();

    }
    */

}}

