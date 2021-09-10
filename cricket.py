class Player:
    def __init__(self, name, wicket=10, over=10, player_type="Human"):
        self.playerType: str = player_type
        self.name: str = name
        self.__maxWicketsAllotted = wicket
        self.__maxOversAllotted = over
        self.currentHit: int
        self.currentScore: int = 0
        self.currentOvers: list = list()
        self.remainingWicket: int = self.__maxWicketsAllotted
        self.remainingOver: int = self.__maxOversAllotted
        self.remainingBalls: int = 0
        self.totalScore: int = 0

    def showInfo(self):
        print("Name:", self.name)
        print("Type:", self.playerType)
        print("Wickets Allotted:", self.__maxWicketsAllotted)
        print("Overs Allotted:", self.__maxOversAllotted)

    def showScore(self):
        print("Total Score:", self.totalScore)
        print("Overs Played:", self.currentOvers[0], "Overs", self.currentOvers[1])


class Human(Player):

    def __init__(self, name, wicket=10, over=10):
        Player.__init__(self, name, wicket, over)

    def throwToss(self):
        self.tossChoice = input("Heads or Tails?\nEnter your choice:")
        if self.tossChoice.upper() not in ["HEADS", "TAILS", "T", "H"]:
            print(self.tossChoice, "is invalid. Please select a valid option")
            self.throwToss()
        else:
            print("You chose: ", self.tossChoice)

    def play(self):
        try:
            self.currentHit = int(input("Enter your hit: "))
        except ValueError:
            print("Invalid Input")
            self.play()


class Bot(Player):

    def __init__(self, name, wickets=10, overs=10):
        self.currentHit = 5
        self.hitHistory: dict = dict()
        self.frequency: dict = dict()
        Player.__init__(self, name, wickets, overs, "Bot")

    def play(self, mode):
        self.currentHit = 5  # self.analyse(self,mode)

    def update(self, hit, if_wicket=False):
        if not if_wicket and hit != 0:
            self.frequency[hit] = self.frequency[hit] + 1 if hit in self.frequency.keys() else 1
        elif if_wicket and hit != 0:
            self.hitHistory[hit] = self.hitHistory[hit] + 1 if hit in self.hitHistory.keys() else 1
        else:
            return


import random


class Play:
    def __init__(self):
        self.bot: Bot
        self.human: Human
        self.wickets: int = 0
        self.overs: int = 0
        self.playerName: str = str()
        self.botName: str = str()
        self.playType: str = str()
        self.isOutBot: bool = False
        self.isOutPlayer: bool = False
        self.outCounter: int = 0

    def start(self):
        playerName = input("Enter your name: ")
        if input("Do you want to give bot a name? ").lower() in ["yes", "y"]:
            self.botName = input("Enter name: ")
        if input("Do you want to change the default settings (wickets=10 && overs=10)? ").lower() in ["yes", "y"]:
            self.wickets = int(input("Enter wickets: "))
            self.overs = int(input("Enter overs: "))
        self.bot = Bot(self.botName, self.wickets, self.overs)
        self.human = Human(self.playerName, self.wickets, self.overs)
        # print("Player Details:")
        # self.human.showInfo()
        # self.bot.showInfo()
        # Toss:
        while True:
            self.human.throwToss()
            if int(random.random() * 6) % 2 != 0:
                choice = input(
                    "You Won!\nPlease selet your options: \tOffense (O) or Defence (D)\nPlease enter: ").lower()
                self.human.tossResult = "Won"
            else:
                choice = "o" if int(random.random() * 6) % 2 != 0 else "d"
            print(choice)
            if choice in ["o", "d"]:
                self.playType = choice.lower()
                print(choice)
                break
        # Toss:
        # Play:
        while (True):
            self.human.play()
            self.bot.play(self.playType)
            if self.playType == "o":
                if self.human.remainingBalls == 0:
                    self.human.remainingOver -= 1
                    self.human.remainingBalls = 6
                self.human.remainingBalls -= 1
                if self.human.currentHit == self.bot.currentHit:
                    self.human.remainingWicket -= 1
                    print("Ok")
                    self.isOutPlayer = self.human.remainingWicket == 0 or (
                            self.human.remainingOver == self.human.remainingBalls == 0)
                else:
                    self.human.totalScore += self.human.currentHit
            else:
                if self.bot.remainingBalls == 0:
                    self.bot.remainingOver -= 1
                    self.bot.remainingBalls = 6
                self.bot.remainingBalls -= 1
                if self.bot.currentHit == self.human.currentHit:
                    self.bot.remainingWicket -= 1
                    print("Ok")
                    self.isOutBot = self.human.remainingWicket == 0 or (
                            self.human.remainingOver == self.human.remainingBalls == 0)
                else:
                    self.bot.totalScore += self.bot.currentHit
            if self.isOutBot or self.isOutPlayer and self.outCounter == 0:
                print("Pog")
                self.outCounter += 1
                self.playType = "o" if self.playType == "d" else "d"
            if self.isOutBot and self.isOutPlayer:
                self.human.currentOvers = [self.human.remainingOver, self.human.remainingBalls]
                self.bot.currentOvers = [self.bot.remainingOver, self.bot.remainingBalls]
                # self.human.showScore()
                # self.bot.showScore()
                break
            if (self.isOutBot and self.bot.totalScore < self.human.totalScore) or (self.isOutPlayer and self.human.totalScore < self.bot.totalScore):
                print("Bot Won" if self.bot.totalScore > self.human.totalScore else
                      "You Won!!!" if self.bot.totalScore < self.human.totalScore else
                      "Tied!!!")
                break


Play().start()
