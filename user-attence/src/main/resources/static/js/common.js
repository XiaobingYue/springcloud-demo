$(function () {
    //全局的ajax访问异常提示
    $.ajaxSetup({
        complete: function (resp, textStatus) {
            if (resp.status != 200) {
                if (resp.status == 403) {
                    alert("系统内部错误，请重新登陆!\r\n");
                } else if (resp.status < 500 && resp.status >= 400) {
                    alert("请求出错!\r\n" + resp.responseText);
                } else if (resp.status >= 500) {
                    alert("服务器异常!\r\n" + resp.responseText);
                }
            }
        }
    });

    loadPersonList();
    $('#userLink').click(function () {
        loadPersonList();
    });

    $('#orgLink').click(function () {
        loadOrgList();
    });

    $('#userOrgLink').click(function () {
        loadPersonOrgList();
    });

    $('#attenceLink').click(function () {
        getAllRecordsV2();
    });
});

$('#myTab a').click(function (e) {
    e.preventDefault();
    $(this).tab('show');
});

function handleListData(data, type) {
    if (data.code === '1') {
        const list = data.data;
        var content = '';
        if (type === 1) {
            if (list.length <= 0) {
                $('#person tbody').html('');
                return;
            }
            $.each(list, function (i, info) {
                content = content + '<tr>';
                content = content + '  <td>' + (i + 1) + '</td>';
                // content = content + '  <td><input type="checkbox" value="' + role.id + '"></td>';
                content = content + '  <td>' + info.name + '</td>';
                content = content + '  <td>' + info.identifier + '</td>';
                content = content + '  <td>' + info.gender + '</td>';
                content = content + '  <td>' + info.email + '</td>';
                content = content + '  <td>' + info.telephone + '</td>';
                content = content + '  <td>';
                content = content + '      <button type="button" title="生成账户" onclick="bindDep(\'' + info.id + '\')" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
                content = content + '      <button type="button" title="删除" onclick="deletePerson(\'' + info.id + '\')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
                content = content + '  </td>';
                content = content + '</tr>';
            });
            $('#person tbody').html(content);
            return;
        }
        if (type === 2) {
            if (list.length <= 0) {
                $('#org tbody').html('');
                return;
            }
            $.each(list, function (i, info) {
                content = content + '<tr>';
                content = content + '  <td>' + (i + 1) + '</td>';
                content = content + '  <td>' + info.name + '</td>';
                content = content + '  <td>' + info.code + '</td>';
                content = content + '  <td>';
                content = content + '      <button type="button" title="生成账户" onclick="bindPerson(\'' + info.id + '\')" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
                content = content + '      <button type="button" title="删除" onclick="deleteOrg(\'' + info.id + '\')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
                content = content + '  </td>';
                content = content + '</tr>';
            });
            $('#org tbody').html(content);
            return;
        }
        if (type === 3) {
            $.each(list, function (i, info) {
                content = content + '<tr>';
                content = content + '  <td>' + (i + 1) + '</td>';
                content = content + '  <td>' + info.code + '</td>';
                content = content + '  <td>' + info.person.name + '</td>';
                content = content + '  <td>' + info.org.name + '</td>';
                content = content + '  <td>' + info.position + '</td>';
                content = content + '  <td>' + info.officeEmail + '</td>';
                content = content + '  <td>' + info.officePhone + '</td>';
                content = content + '  <td>';
                content = content + '      <button type="button" title="打卡" onclick="checkIn(\'' + info.id + '\')" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
                content = content + '      <button type="button" title="打卡记录" onclick="openCheckRecords(\'' + info.id + '\')" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-list"></i></button>';
                content = content + '      <button type="button" title="删除" onclick="deletePersonDep(\'' + info.id + '\')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
                content = content + '  </td>';
                content = content + '</tr>';
            });
            $('#personOrg tbody').html(content);
            return;
        }
        if (type === 4) {
            var attenceList = list.attenceList;
            $.each(attenceList, function (i, info) {
                content = content + '<tr>';
                content = content + '  <td>' + (i + 1) + '</td>';
                content = content + '  <td>' + list.code + '</td>';
                content = content + '  <td>' + list.person.name + '</td>';
                content = content + '  <td>' + list.org.name + '</td>';
                content = content + '  <td>' + formatTimestamp(info.checkInTime) + '</td>';
                content = content + '</tr>';
            });
            $('#checkRecordsTable tbody').html(content);
        }
    } else {
        alert("数据加载失败");
    }
}

function getFormData($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

function formatTimestamp(value) {
    var date = new Date(value);
    return date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes();
}