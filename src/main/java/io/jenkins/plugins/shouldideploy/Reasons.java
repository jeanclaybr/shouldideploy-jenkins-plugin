package io.jenkins.plugins.shouldideploy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author jean
 */
public enum Reasons {

  REASONS_TO_DEPLOY() {

    @Override
    protected List<String> reasons() {
      return List.of(
        "I don't see why not",
        "It's a free country",
        "Go ahead my friend!",
        "Go for it",
        "Go go go go!",
        "Let's do it!",
        "Ship it! 🚢",
        "Go with the flow 🌊",
        "Harder better faster stronger",
        "Rock on!",
        "Make me proud",
        "Break a leg!",
        "This Is the Way",
        "Strike First, Strike Hard, No Mercy!"
      );
    }

  },
  REASONS_TO_NOT_DEPLOY() {
    @Override
    protected List<String> reasons() {
      return List.of(
        "I wouldn't recommend it",
        "No, it's Friday",
        "What about Monday?",
        "Not today",
        "Nope",
        "Why?",
        "Did the tests pass? Probably not",
        "¯\\_(ツ)_/¯",
        "😹",
        "No",
        "No. Breathe and count to 10, start again",
        "I'd rather have ice-cream 🍦",
        "How could you? 🥺",
        "Some people just want to watch the world burn 🔥",
        "You like fire don't you?"
      );
    }
  },
  REASONS_FOR_THURSDAY_AFTERNOON() {
    @Override
    protected List<String> reasons() {
      return List.of(
        "You still want to sleep?",
        "Call your partner!",
        "Gonna stay late today?",
        "Tell your boss that you found a bug and go home",
        "What about Monday?",
        "I wouldn't recommend it",
        "Not today",
        "Nope",
        "No. Breathe and count to 10, start again"
      );
    }
  },
  REASONS_FOR_FRIDAY_AFTERNOON {
    @Override
    protected List<String> reasons() {
      return List.of(
        "Not by any chance",
        "U mad?",
        "What you are thinking?",
        "No no no no no no no no",
        "How do you feel about working nights and weekends?",
        "🔥 🚒 🚨 ⛔️ 🔥 🚒 🚨 ⛔️ 🔥 🚒 🚨 ⛔️",
        "No! God! Please! No",
        "No no no no no no no!",
        "Keep dreaming darling",
        "Why why Bro why?",
        "But but but... why?",
        "Deploys are for Monday, so you can fix them till Friday.",
        "YOLO ! You only live once !"
      );
    }
  },
  REASONS_FOR_FRIDAY_13TH {
    @Override
    protected List<String> reasons() {
      return List.of(
        "Man, really? It's friday the 13th!",
        "Do you believe in bad luck?",
        "Jason is watching you",
        "If you want to spend your weekend in Crystal Lake, go ahead",
        "To pray is no help if you take this bad decision",
        "Did you look at the calendar today?",
        "📅 Friday the 13th. What do you think about it?",
        "Just no!",
        "But but but... why?"
      );
    }
  },
  REASONS_FOR_AFTERNOON {
    @Override
    protected List<String> reasons() {
      return List.of(
        "You still want to sleep?",
        "Call your partner!",
        "Gonna stay late today?",
        "Tomorrow?",
        "No",
        "Tell your boss that you found a bug and go home",
        "You have full day ahead of you tomorrow!",
        "Trust me, they will be much happier if it wasn't broken for a night",
        "How much do you trust your logging tools?"
      );
    }
  },
  REASONS_FOR_WEEKEND {
    @Override
    protected List<String> reasons() {
      return List.of(
        "Go home, you're drunk",
        "How about Monday?",
        "Beer?",
        "Drunk development is not a good idea!",
        "I see you deployed on Friday",
        "Told you that Monday would be a better idea!"
      );
    }
  },
  REASONS_FOR_DAY_BEFORE_CHRISTMAS {
    @Override
    protected List<String> reasons() {
      return List.of(
        "Are you Santa 🧑‍🎄 or what?",
        "🎶🎵 You better watch out 🎵🎶",
        "🎄 Enjoy the holiday season! 🎄 ",
        "Just take another glass of eggnog",
        "Can't you just wait after present unwrapping?",
        "Sure, deploy... \n your family will appreciate you fixing things on your phone during dinner"
      );
    }
  },
  REASONS_FOR_CHRISTMAS {
    @Override
    protected List<String> reasons() {
      final List<String> reasons = new ArrayList<>(REASONS_FOR_DAY_BEFORE_CHRISTMAS.reasons());
      reasons.addAll(
        List.of(
          "No, Rudolf will hunt you down 🦌 ",
          "Just watch Home Alone today",
          "Shouldn't you be preparing a christmas diner?"
        )
      );
      return reasons;
    }
  },
  REASONS_NEW_YEAR {
    @Override
    protected List<String> reasons() {
      return List.of(
        "Happy New Year! \n deploy the 2nd of january",
        "Aren't you hungover?",
        "Take another glass of champagne 🥂",
        "Celebrate today, deploy tomorrow 🎇"
      );
    }
  };

  public String reason() {
    final List<String> reasons = this.reasons();
    final int index = random().nextInt(reasons.size());
    return reasons.get(index);
  }

  protected abstract List<String> reasons();

  private static Random random() {
    return ThreadLocalRandom.current();
  }
}
