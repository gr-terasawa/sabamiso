$(function() {

  Morris.Area({
  element: 'morris-area-chart',
  data: [{
        time: '2014-01-20 00:00',
        collect: 19
    }, {
    	time: '2014-01-20 01:00',
        collect: 17
    }, {
    	time: '2014-01-20 02:00',
        collect: 15
    }, {
    	time: '2014-01-20 03:00',
        collect: 12
    }, {
    	time: '2014-01-20 04:00',
        collect: 13
    }, {
    	time: '2014-01-20 05:00',
        collect: 10
    }, {
    	time: '2014-01-20 06:00',
        collect: 11
    }, {
    	time: '2014-01-20 07:00',
        collect: 8
    }, {
    	time: '2014-01-20 08:00',
        collect: 7
    }, {
    	time: '2014-01-20 09:00',
        collect: 3
    }, {
    	time: '2014-01-20 10:00',
        collect: 5
    }, {
    	time: '2014-01-20 11:00',
        collect: 2
    }, {
    	time: '2014-01-20 12:00',
        collect: 1
    }, {
    	time: '2014-01-20 13:00',
        collect: 0
    }, {
    	time: '2014-01-20 14:00',
        collect: 1
    }, {
    	time: '2014-01-20 15:00',
        collect: 3
    }, {
    	time: '2014-01-20 16:00',
        collect: 0
    }, {
    	time: '2014-01-20 17:00',
        collect: 0
    }, {
        time: '2014-01-20 18:00',
        collect: 0
    }, {
        time: '2014-01-20 19:00',
        collect: 0
    }, {
        time: '2014-01-20 20:00',
        collect: 0
    }, {
        time: '2014-01-20 21:00',
        collect: 2
    }, {
        time: '2014-01-20 22:00',
        collect: 1
    }, {
        time: '2014-01-20 23:00',
        collect: 0
    }],
    xkey: 'time',
    ykeys: ['collect'],
    labels: ['sample'],
    pointSize: 2,
    hideHover: 'auto',
    resize: true
});

//    Morris.Area({
//        element: 'morris-area-chart',
//        data: [{
//            time: '2010 Q1',
//            iphone: 2666,
//            ipad: null,
//            itouch: 2647
//        }, {
//            time: '2010 Q2',
//            iphone: 2778,
//            ipad: 2294,
//            itouch: 2441
//        }, {
//            time: '2010 Q3',
//            iphone: 4912,
//            ipad: 1969,
//            itouch: 2501
//        }, {
//            time: '2010 Q4',
//            iphone: 3767,
//            ipad: 3597,
//            itouch: 5689
//        }, {
//            time: '2011 Q1',
//            iphone: 6810,
//            ipad: 1914,
//            itouch: 2293
//        }, {
//            time: '2011 Q2',
//            iphone: 5670,
//            ipad: 4293,
//            itouch: 1881
//        }, {
//            time: '2011 Q3',
//            iphone: 4820,
//            ipad: 3795,
//            itouch: 1588
//        }, {
//            time: '2011 Q4',
//            iphone: 15073,
//            ipad: 5967,
//            itouch: 5175
//        }, {
//            time: '2012 Q1',
//            iphone: 10687,
//            ipad: 4460,
//            itouch: 2028
//        }, {
//            time: '2012 Q2',
//            iphone: 8432,
//            ipad: 5713,
//            itouch: 1791
//        }],
//        xkey: 'time',
//        ykeys: ['iphone', 'ipad', 'itouch'],
//        labels: ['iPhone', 'iPad', 'iPod Touch'],
//        pointSize: 2,
//        hideHover: 'auto',
//        resize: true
//    });

    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "Download Sales",
            value: 12
        }, {
            label: "In-Store Sales",
            value: 30
        }, {
            label: "Mail-Order Sales",
            value: 20
        }],
        resize: true
    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2006',
            a: 100,
            b: 90
        }, {
            y: '2007',
            a: 75,
            b: 65
        }, {
            y: '2008',
            a: 50,
            b: 40
        }, {
            y: '2009',
            a: 75,
            b: 65
        }, {
            y: '2010',
            a: 50,
            b: 40
        }, {
            y: '2011',
            a: 75,
            b: 65
        }, {
            y: '2012',
            a: 100,
            b: 90
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true
    });

});
