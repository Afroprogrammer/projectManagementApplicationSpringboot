var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);
var arrayLength = chartJsonArray.length;


var numericData = [];
var labelData = [];

for(var i=0; i < arrayLength; i++){
    numericData[i] = chartJsonArray[i].points;
    labelData[i] = chartJsonArray[i].label;
}

const ctx = document.getElementById('myChart').getContext('2d');
const my = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: numericData
        }]
    },
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }

    }
});

function decodeHtml(html){
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}
