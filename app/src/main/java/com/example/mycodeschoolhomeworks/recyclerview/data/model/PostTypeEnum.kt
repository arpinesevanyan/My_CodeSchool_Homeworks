package com.example.mycodeschoolhomeworks.recyclerview.data.model

import java.lang.reflect.Type

enum class PostTypeEnum(val post: String) {
    STATUS_ONE("Make love not war"),
    STATUS_TWO("Money can’t buy life"),
    STATUS_THREE("This is just a beginning"),
    STATUS_FOUR("If you can dream it, you can do it "),
    IMAGE_POST_ONE("https://www.saatchiart.com/art/Painting-Everyone-s-Gone/1156185/8268487/view"),
    IMAGE_POST_TWO("https://www.saatchiart.com/art/Painting-New-Land/1156185/4703598/view"),
    IMAGE_POST_THREE("https://www.saatchiart.com/art/Painting-October/1156185/7880817/view"),
    IMAGE_POST_FOUR("https://www.saatchiart.com/art/Painting-Spring/1156185/9222891/view"),
    VIDEO_POST_ONE("https://www.youtube.com/watch?v=31E2tSxE35I"),
    VIDEO_POST_TWO("https://www.youtube.com/watch?v=kTvjH-eHPZQ"),
    VIDEO_POST_THREE("https://www.youtube.com/watch?v=O1LDjwZcN9s"),
    VIDEO_POST_FOUR("https://www.youtube.com/watch?v=pvSKV0NhfNM"),
    TEXT_POST_ONE("At one of the factories of Henry Fonda, a team of workers received money for having a rest. This was the service brigade that was used to oversee the operation of the conveyor. In other words, repairman. They only got paid when they sat in the rest room. As soon as the assembly line breakage lamp came on, the counter stopped and charged them money. Secondly, they always promptly made repairs in order to return to the rest room faster. Secondly, so that they always shoot high quality, they did not have to leave the room in the near future because of the same ineptitude."),
    TEXT_POST_TWO("And once the storm is over, you won’t remember how you made it through, how you managed to survive. You won’t even be sure, whether the storm is really over. But one thing is certain. When you come out of the storm, you won’t be the same person who walked in. That’s what this storm’s all about.”"),
    TEXT_POST_THREE("It comes from Positive Thinking Only, “Use your smile to change the world, don't let the world change your smile”. A smile is a universal expression. It speaks all languages, overcomes all differences, and holds all space. It's something that two people can always share and instantly connect."),
    TEXT_POST_FOUR("We always think there is a forever and always demean the last time and then we regret the last time. How we didn't cherish each moment. We always expect love to end well, and have more and these expectations are the pain that we get when we realised all these are not reality and nothing lasts forever."),
}