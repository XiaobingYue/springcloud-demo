function loadPersonList() {
    $.get(path + '/person/list', function (data) {
        handleListData(data, 1);
    })
}

function bindDep(id) {
    $.get(path + '/org/list', function (data) {
        if (data.code === '1') {
            const list = data.data;
            var content = '';
            $.each(list, function (i, info) {
                content += '<option value="' + info.id + '">' + info.name + '</option>';
            });
            $('#chooseOrg').html(content);
            $('#chooseOrg').selectpicker('refresh');
            $('#personId').val(id);
            $('#bindDep').modal('show');
        } else {
            alert("数据加载失败");
        }
    });
}

function savePerson() {
    $.ajax({
        type: 'post',
        url: path + '/person/add',
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(getFormData($('#personForm'))),
        success: function (data) {
            if (data.code === '1') {
                alert("保存成功");
                $('#addPerson').modal('hide');
                $('#myTab a:first').tab('show');
                loadPersonList();
            } else {
                alert("保存失败");
            }
        },
        error: function () {
            alert("保存失败");
        }
    })
}

function deletePerson(id) {
    $.get(path + '/person/delete?id=' + id, function (data) {
        if (data.code === '1') {
            alert("删除成功");
            $('#myTab a:first').tab('show');
            loadPersonList();
        } else {
            alert(data.message);
        }
    })
}