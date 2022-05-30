$(document).ready(function() {
    //I'm using DataTable plugin for the table
    // Setup - add a text input to each footer cell
    $('#student-table tfoot th').each( function () {
        var title = $('#student-table thead th').eq( $(this).index() ).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
    } );
 
    // DataTable
    var table = $('#student-table').DataTable();
 
    // Apply the search
    table.columns().every( function () {
        var that = this;
 
        $( 'input', this.footer() ).on( 'keyup change', function () {
            that
                .search( this.value )
                .draw();
        } );
    } );
} );