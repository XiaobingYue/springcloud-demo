function checkIn(id) {
    $.get(path + '/attence/checkIn?accountId=' + id, function (data) {
        if (data.code === '1') {
            alert("打卡成功");
            loadPersonOrgList();
        } else {
            alert(data.message);
        }
    })
}

function openCheckRecords(id) {
    $('#checkRecords').modal('show');
    checkRecords(id);
}

function checkRecords(id) {
    $.get(path + '/attence/list?accountId=' + id, function (data) {
        handleListData(data, 4);
    })
}

function getAllRecords() {
    $.get(path + '/attence/listAll', function (data) {
        if (data.code === '1') {
            const personOrgList = data.data;
            var content = '';
            if (personOrgList.length <= 0) {
                $('#attenceTable tbody').html('');
                return;
            }
            var n = 0;
            $.each(personOrgList, function (i, personOrg) {
                $.each(personOrg.attenceList, function (j, attence) {
                    n++;
                    content = content + '<tr>';
                    content = content + '  <td>' + n + '</td>';
                    content = content + '  <td>' + personOrg.code + '</td>';
                    content = content + '  <td>' + personOrg.person.name + '</td>';
                    content = content + '  <td>' + personOrg.org.name + '</td>';
                    content = content + '  <td>' + formatTimestamp(attence.checkInTime) + '</td>';
                    content = content + '</tr>';
                });

            });
            $('#attenceTable tbody').html(content);
        } else {
            alert(data.message);
        }
    })
}

function getAllRecordsV2() {
    $.get(path + '/attence/v2/listAll', function (data) {
        if (data.code === '1') {
            const attenceList = data.data;
            var content = '';
            if (attenceList.length <= 0) {
                $('#attenceTable tbody').html('');
                return;
            }
            $.each(attenceList, function (j, attence) {
                content = content + '<tr>';
                content = content + '  <td>' + (j+1) + '</td>';
                content = content + '  <td>' + attence.code + '</td>';
                content = content + '  <td>' + attence.person.name + '</td>';
                content = content + '  <td>' + attence.org.name + '</td>';
                content = content + '  <td>' + formatTimestamp(attence.checkInTime) + '</td>';
                content = content + '</tr>';
            });
            $('#attenceTable tbody').html(content);
        } else {
            alert(data.message);
        }
    })
}