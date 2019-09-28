class City():
    def __init__(self, name, population):
        self.name = name
        self.population = population
        self.flights = []

    def addFlightTo(self, destinationCity):
        flight = Flight(self, destinationCity)
        self.flights.append(flight)

    def __repr__(self):
        return self.name + "(" + str(self.population) + ")"
        
class Flight():
    def __init__(self, sourceCity, destinationCity):
        self.source = sourceCity
        self.destination = destinationCity

# This is a comment
    
ankara = City('Ankara', 4500000)
istanbul = City('Istanbul', 15000000)
izmir = City('Izmir', 3000000)
istanbul.addFlightTo(ankara)
istanbul.addFlightTo(izmir)
izmir.addFlightTo(ankara)
ankara.addFlightTo(izmir)
ankara.addFlightTo(istanbul)
cities = [istanbul, ankara, izmir]
