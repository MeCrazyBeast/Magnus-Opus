import math
import random


class Stats:
    def __init__(self, level, stamina, strength, intelligence, agility):
        self.LEVEL = level
        self.stamina = stamina
        self.intelligence = intelligence
        self.agility = agility
        self.strength = strength
        self.ATK: int
        self.DEF: int
        self.LEVEL_MULTIPLIER = (self.LEVEL * math.pi / 99)
        self.HEALTH = self.stamina * self.LEVEL_MULTIPLIER * (self.strength + self.intelligence) / 2
        if self.strength > self.intelligence:
            self.ATK = self.LEVEL_MULTIPLIER * self.strength
        else:
            self.ATK = self.LEVEL_MULTIPLIER * self.intelligence

    def display_stats(self):
        print("Stamina: ", self.stamina)
        print("Intelligence: ", self.intelligence)
        print("Strength: ", self.strength)
        print("Agility: ", self.agility)

    def atk(self):
        if random.randint(0, 100) <= 85:
            return self.ATK,False
        else:
            return self.ATK*math.e,True


user = Stats(100, 150, 128, 86, 18)
user.display_stats()
DAMAGE, CRITICAL = user.atk()
if CRITICAL:
    print("Critical Hit!!!")
print("Damage Done: ", DAMAGE)
