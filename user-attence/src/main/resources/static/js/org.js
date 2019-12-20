function loadOrgList() {
    $.get(path + '/org/list', function (data) {
        handleListData(data, 2);
    })
}

function bindPerson(id) {
    $.get(path + '/person/list', function (data) {
        if (data.code === '1') {
            const list = data.data;
            var content = '';
            $.each(list, function (i, info) {
                content += '<option value="' + info.id + '">' + info.name + '</option>';
            });
            $('#choosePerson').html(content);
            $('#choosePerson').selectpicker('refresh');
            $('#orgId').val(id);
            $('#bindPerson').modal('show');
        } else {
            alert("数据加载失败");
        }
    });
}

function saveOrg() {
    $.ajax({
        type: 'post',
        url: path + '/org/add',
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(getFormData($('#orgForm'))),
        success: function (data) {
            if (data.code === '1') {
                alert("保存成功");
                $('#addOrg').modal('hide');
                $('#myTab a[href="#org"]').tab('show');
                loadOrgList();
            } else {
                alert("保存失败");
            }
        },
        error: function () {
            alert("保存失败");
        }
    })
}

function deleteOrg(id) {
    $.get(path + '/org/delete?id=' + id, function (data) {
        if (data.code === '1') {
            alert("删除成功");
            $('#myTab a[href="#org"]').tab('show');
            loadOrgList();
        } else {
            alert(data.message);
        }
    })
}
