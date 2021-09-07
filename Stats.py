import math
import random


class Stats:
    def __init__(self, level: int, stamina: int, strength: int, intelligence: int, agility: int, race_object=1):
        self.STAMINA = stamina
        self.STRENGTH = strength
        self.INTELLIGENCE = intelligence
        self.AGILITY = agility
        self.LEVEL = level
        self.ADDITIONAL_MULTIPLIER = 1  # [1, 1, 1, 1, 1]
        self.LEVEL_MULTIPLIER = race_object * (race_object * self.LEVEL) / 100
        self.STAMINA_MULTIPLIER = (math.log(self.STAMINA)) * race_object * self.ADDITIONAL_MULTIPLIER
        self.MANA_MULTIPLIER = (math.log(self.INTELLIGENCE)) * race_object * self.ADDITIONAL_MULTIPLIER
        self.STRENGTH_MULTIPLIER = (math.log(self.STRENGTH)) * race_object * self.ADDITIONAL_MULTIPLIER * (
                self.STRENGTH / self.STAMINA)
        self.PHYSICAL_MULTIPLIER = (math.log(
            self.STAMINA * self.STRENGTH)) * race_object * self.ADDITIONAL_MULTIPLIER
        self.MAGICAL_MULTIPLIER = (math.log(
            self.STAMINA * self.INTELLIGENCE)) * race_object * self.ADDITIONAL_MULTIPLIER
        self.CRITICAL_HIT_RATE = 1
        self.CRITICAL_DAMAGE = 1 + race_object * self.LEVEL_MULTIPLIER * self.PHYSICAL_MULTIPLIER * self.MAGICAL_MULTIPLIER / 100
        self.EXPERIENCE_POINTS_REQUIRED = math.pow(math.e, math.log(self.LEVEL)) + self.LEVEL * self.LEVEL_MULTIPLIER

    def display_stats(self):
        print("Stamina: ", self.STAMINA)
        print("Intelligence: ", self.INTELLIGENCE)
        print("Strength: ", self.STRENGTH)
        print("Agility: ", self.AGILITY)

    def check_critical(self):
        if random.randrange(0, 100) < math.pi * self.CRITICAL_HIT_RATE:
            return True
        return False

    def atk(self, mode=None):
        if self.check_critical():
            return self.STRENGTH * self.CRITICAL_DAMAGE * self.PHYSICAL_MULTIPLIER, True
        return self.STRENGTH * self.PHYSICAL_MULTIPLIER, False


user = Stats(100, 150, 128, 86, 18)
user.display_stats()
DAMAGE, CRITICAL = user.atk()
if CRITICAL:
    print("Critical Hit!!!")
print("Damage Done: ", DAMAGE)
