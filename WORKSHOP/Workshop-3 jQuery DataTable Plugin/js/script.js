var table;

var emps=[];
$(document).ready(function () {
    table=$('#mytable').DataTable();
    $.getJSON('../json/data.json', function (data) {
        console.log(data);
        emps=data;
        //var table = $('#example').DataTable({
        //     select: false,
        //     "columnDefs": [{
        //         className: "Name",
        //         "targets": [0],
        //         "visible": false,
        //         "searchable": false
        //     }]
        // });

        $('#example tbody').on('click', 'tr', function () {
            alert(table.row(this).data()[0]);
        });
        //var trHTML = '';
        $.each(emps, function (i, item) {
           // trHTML += '<tr><td>' + data[i].id + '<tr><td>' + data[i].sender + '</td><td>' + data[i].received + '</td></tr>';
            table.row.add([item.id,item.sender,item.received]).draw(false);
        });
          //  $('#t-body').append(trHTML);
    });
});

