import numpy as np
from sklearn.tree import DecisionTreeRegressor
import matplotlib.pyplot as plt
z = zipfile.ZipFile('../input/train.csv.zip')
train = pd.read_csv(z.open('train.csv'), parse_dates=['Dates'])[['X', 'Y', 'Category']]



