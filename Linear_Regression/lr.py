import pandas as pd
import numpy as np
from sklearn.preprocessing import MinMaxScaler
import plotext as plt




df = pd.read_csv('advertising.csv')

def linear_regression(x , y , w , w0 , iters=1000, learning_rate = 0.01):
    N = len(y)
    rss_l = []
    for i in range(iters):
        y_pred = np.dot(x , w) + w0
        rss = np.square(np.subtract(y , y_pred)).mean()
        w0_slope = (-2 * np.sum(y - y_pred))/N
        w_slope = (-(y - y_pred).dot(2 * x))/N
        
        w -= learning_rate * w_slope
        w0 -= learning_rate * w0_slope
        
        rss_l.append(rss)
        
    return w , w0 , rss_l

scaler = MinMaxScaler()
x = scaler.fit_transform(df[['TV' , 'Radio' , 'Newspaper']])
y = df['Sales']
w0 = 0
w = np.zeros(x.shape[1])

w_new , w0_new , rss_l = linear_regression(x , y , w , w0)
print(w_new)
print(w0_new)
print(rss_l)
plt.plot(rss_l)
plt.show()