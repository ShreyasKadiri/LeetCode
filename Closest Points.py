from random import randint
from math import sqrt

def dist(point):
	return sqrt(point[0]**2 + point[1]**2)

def k_smallest(k, a):
	if k == len(a): return a
	splitElm = a[randint(0, len(a) - 1)]
	a1 = [e for e in a if dist(e) <= dist(splitElm)]
	a2 = [e for e in a if dist(e) > dist(splitElm)]
	if k <= len(a1):
		return k_smallest(k, a1)
	else:
		return a1 + k_smallest(k - len(a1), a2)
