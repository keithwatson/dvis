var data = [1, 2, 3, 4];

/* Sizing and scales. */
var w = 800,
    h = 500,
    x = pv.Scale.linear(0, 1.1).range(0, w),
    y = pv.Scale.ordinal(pv.range(10)).splitBanded(0, h, 4/5);

/* The root panel. */
var vis = new pv.Panel()
    .width(w)
    .height(h)
    .bottom(20)
    .left(20)
    .right(10)
    .top(5);

/* The bars. */
var bar = vis.add(pv.Bar)
    .data(data)
    .top(function() y(this.index))
    .height(y.range().band)
    .left(0)
    .width(x);

/* The value label. */
bar.anchor("right").add(pv.Label)
    .textStyle("white")
    .text(function(d) d.toFixed(1));

/* The variable label. */
bar.anchor("left").add(pv.Label)
    .textMargin(5)
    .textAlign("right")
    .text(function() "ABCDEFGHIJK".charAt(this.index));

/* X-axis ticks. */
vis.add(pv.Rule)
    .data(x.ticks(5))
    .left(x)
    .strokeStyle(function(d) d ? "rgba(255,255,255,.3)" : "#000")
  .add(pv.Rule)
    .bottom(0)
    .height(5)
    .strokeStyle("#000")
  .anchor("bottom").add(pv.Label)
    .text(x.tickFormat);

vis.render();