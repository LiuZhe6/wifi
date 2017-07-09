// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));

// 指定图表的配置项和数据
var option = {
    title: {
        text: '全国总客流量'
    },
    toolbox: {
        show: true,
        feature: {
            saveAsImage: {
                show: true
            }
        }
    },
    legend: {
        data: ['销量']
    },
    xAxis: {
        data: ["2017-3", "2017-4", "2017-5","2017-6","2017-7","2017-8"]
    },
    yAxis: {},
    series: [{

        name: '销量',
        type: 'bar',
        data: [5, 20, 36, 10, 10, 20]
    },{

        name: '产量',
        type: 'line',
        data: [7, 30, 50, 11, 40, 80]
    }]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);