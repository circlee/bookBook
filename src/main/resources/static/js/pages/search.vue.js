var search = Vue.component("Search", {
    template:
        `
         <div class="content-wrapper">
            <div class="page albums-index-page entity-index-page">
                <div class="content-header">
                    <h1 class="content-title">
                        <span>Books</span>
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fas fa-dashboard"></i>
                            <a href="/" class="active">Home</a>
                        </li>
                        <li>Books</li>
                    </ol>
                </div>
                <div class="content">
                    <div class="box">
                        <!---->
                        <div style="">
                            <div class="box-header with-border">
                                <div class="row">
                                    
                                    <div class="col-lg-3 col-md-6">
                                        <div class="form-group">
                                            <input placeholder="Search" class="form-control field" stagger="300">
                                        </div>
                                    </div>
                                </div>
                                <div class="entity-filters">
                                    <div class="row"></div>
                                </div>
                            </div>
                            <div class="box-body table-responsive no-padding">
                                <table class="table entity-table table-bordered">
                                    <thead>
                                        <tr>
                                            <th class="item-cell-id"><span>Id</span>
                                            </th>
                                            <th class="item-cell-created-at"><span>Created At</span>
                                            </th>
                                            <th class="item-cell-slug"><span>Slug</span>
                                            </th>
                                            <th class="item-cell-name"><span>Name</span>
                                            </th>
                                            <th class="table-item-actions"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr id="albums-item-1" class="">
                                            <td id="albums-item-1-id" class="item-cell-id">
                                                <div>1</div>
                                            </td>
                                            <td id="albums-item-1-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-1-slug" class="item-cell-slug">
                                                <div>decentralized-holistic-initiative</div>
                                            </td>
                                            <td id="albums-item-1-name" class="item-cell-name">
                                                <div>Decentralized holistic initiative</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/1" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        
                                    </tbody>
                                    <!---->
                                </table>
                            </div>
                            <nav class="pager-wrapper box-footer">
                                <div class="well well-sm">Elements shown: <span>20</span></div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>`
    ,
    props: []
    , data: function () {
        return {id: '', password: ''};
    }
    , methods: {
        submit: function () {

        }
    }
});