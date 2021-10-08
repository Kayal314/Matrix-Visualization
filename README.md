Visualization of heterogeneity in a matrix by mapping the values in the matrix to RGB values: <br>
We aim to contruct heat-maps of matrices in java, similar to the imagesc function in octave
<p align="center"><img src="MatVis2.png"></p>

To get the heat map of a matrix _arr_ first initialize a new *Display* object with _arr_ <br>
**Display dis = new Display(_arr_);** <br>
Then call the _show_ method to create the heat-map <br>
**dis.show();** <br>
You can also show a color-scale for reference: <br>
**dis.colorBar(100)** // divided the color-bar into hundred divisions. For a more accurate scale, use a higher value, although 100 is the recommended value
