var search = Vue.component("Search", {
    template:
        `<div class="content-wrapper">
            <div class="page albums-index-page entity-index-page">
                <div class="content-header">
                    <h1 class="content-title">
                        <span>Albums</span>
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fas fa-dashboard"></i>
                            <a href="/" class="active">Home</a>
                        </li>
                        <li>Albums</li>
                    </ol>
                </div>
                <div class="content">
                    <div class="box">
                        <!---->
                        <div style="">
                            <div class="box-header with-border">
                                <div class="row">
                                    <div class="col-lg-9 col-md-6">
                                        <div class="form-group inline per-page">
                                            <div class="field-title">Per page:</div>
                                            <div dir="auto" class="dropdown v-select field single unsearchable required">
                                                <div class="dropdown-toggle clearfix">
                                                    <span class="selected-tag">
                25
               <!---->
               </span>
                                                    <input type="search" autocomplete="false" readonly="readonly" aria-label="Search for option" class="form-control" style="width: auto;">
                                                    <button type="button" title="Clear selection" class="clear">
                                                        <span aria-hidden="true">×</span>
                                                    </button>
                                                    <i role="presentation" class="open-indicator"></i>
                                                    <div class="spinner" style="display: none;">Loading...</div>
                                                </div>
                                                <!---->
                                            </div>
                                            <!---->
                                        </div>
                                        <a href="/entity/albums/item/new" class="btn btn-success">Create</a>
                                    </div>
                                    <div class="col-lg-3 col-md-6">
                                        <div class="form-group">
                                            <!---->
                                            <input placeholder="Search" class="form-control field" stagger="300">
                                            <!---->
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
                                            <th class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </th>
                                            <th class="sortable item-cell-id"><span>Id</span>
                                                <!---->
                                            </th>
                                            <th class="sortable item-cell-created-at"><span>Created At</span>
                                                <!---->
                                            </th>
                                            <th class="sortable item-cell-slug"><span>Slug</span>
                                                <!---->
                                            </th>
                                            <th class="sortable item-cell-name"><span>Name</span>
                                                <!---->
                                            </th>
                                            <th class="table-item-actions"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr id="albums-item-1" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="1">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
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
                                        <tr id="albums-item-2" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="2">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-2-id" class="item-cell-id">
                                                <div>2</div>
                                            </td>
                                            <td id="albums-item-2-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-2-slug" class="item-cell-slug">
                                                <div>enhanced-fault-tolerant-utilisation</div>
                                            </td>
                                            <td id="albums-item-2-name" class="item-cell-name">
                                                <div>Enhanced fault-tolerant utilisation</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/2" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-3" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="3">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-3-id" class="item-cell-id">
                                                <div>3</div>
                                            </td>
                                            <td id="albums-item-3-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-3-slug" class="item-cell-slug">
                                                <div>reactive-full-range-graphicinterface</div>
                                            </td>
                                            <td id="albums-item-3-name" class="item-cell-name">
                                                <div>Reactive full-range GraphicInterface</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/3" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-4" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="4">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-4-id" class="item-cell-id">
                                                <div>4</div>
                                            </td>
                                            <td id="albums-item-4-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-4-slug" class="item-cell-slug">
                                                <div>streamlined-holistic-alliance</div>
                                            </td>
                                            <td id="albums-item-4-name" class="item-cell-name">
                                                <div>Streamlined holistic alliance</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/4" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-5" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="5">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-5-id" class="item-cell-id">
                                                <div>5</div>
                                            </td>
                                            <td id="albums-item-5-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-5-slug" class="item-cell-slug">
                                                <div>synchronised-executive-infrastructure</div>
                                            </td>
                                            <td id="albums-item-5-name" class="item-cell-name">
                                                <div>Synchronised executive infrastructure</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/5" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-6" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="6">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-6-id" class="item-cell-id">
                                                <div>6</div>
                                            </td>
                                            <td id="albums-item-6-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-6-slug" class="item-cell-slug">
                                                <div>horizontal-optimal-conglomeration</div>
                                            </td>
                                            <td id="albums-item-6-name" class="item-cell-name">
                                                <div>Horizontal optimal conglomeration</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/6" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-7" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="7">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-7-id" class="item-cell-id">
                                                <div>7</div>
                                            </td>
                                            <td id="albums-item-7-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-7-slug" class="item-cell-slug">
                                                <div>organized-demand-driven-focusgroup</div>
                                            </td>
                                            <td id="albums-item-7-name" class="item-cell-name">
                                                <div>Organized demand-driven focusgroup</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/7" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-8" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="8">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-8-id" class="item-cell-id">
                                                <div>8</div>
                                            </td>
                                            <td id="albums-item-8-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-8-slug" class="item-cell-slug">
                                                <div>de-engineered-4thgeneration-time-frame</div>
                                            </td>
                                            <td id="albums-item-8-name" class="item-cell-name">
                                                <div>De-engineered 4thgeneration time-frame</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/8" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-9" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="9">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-9-id" class="item-cell-id">
                                                <div>9</div>
                                            </td>
                                            <td id="albums-item-9-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-9-slug" class="item-cell-slug">
                                                <div>devolved-optimizing-time-frame</div>
                                            </td>
                                            <td id="albums-item-9-name" class="item-cell-name">
                                                <div>Devolved optimizing time-frame</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/9" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-10" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="10">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-10-id" class="item-cell-id">
                                                <div>10</div>
                                            </td>
                                            <td id="albums-item-10-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-10-slug" class="item-cell-slug">
                                                <div>focused-context-sensitive-graphicinterface</div>
                                            </td>
                                            <td id="albums-item-10-name" class="item-cell-name">
                                                <div>Focused context-sensitive GraphicInterface</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/10" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-11" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="11">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-11-id" class="item-cell-id">
                                                <div>11</div>
                                            </td>
                                            <td id="albums-item-11-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-11-slug" class="item-cell-slug">
                                                <div>versatile-attitude-oriented-interface</div>
                                            </td>
                                            <td id="albums-item-11-name" class="item-cell-name">
                                                <div>Versatile attitude-oriented interface</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/11" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-12" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="12">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-12-id" class="item-cell-id">
                                                <div>12</div>
                                            </td>
                                            <td id="albums-item-12-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-12-slug" class="item-cell-slug">
                                                <div>balanced-human-resource-hardware</div>
                                            </td>
                                            <td id="albums-item-12-name" class="item-cell-name">
                                                <div>Balanced human-resource hardware</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/12" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-13" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="13">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-13-id" class="item-cell-id">
                                                <div>13</div>
                                            </td>
                                            <td id="albums-item-13-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-13-slug" class="item-cell-slug">
                                                <div>customizable-actuating-workforce</div>
                                            </td>
                                            <td id="albums-item-13-name" class="item-cell-name">
                                                <div>Customizable actuating workforce</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/13" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-14" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="14">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-14-id" class="item-cell-id">
                                                <div>14</div>
                                            </td>
                                            <td id="albums-item-14-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-14-slug" class="item-cell-slug">
                                                <div>implemented-4thgeneration-firmware</div>
                                            </td>
                                            <td id="albums-item-14-name" class="item-cell-name">
                                                <div>Implemented 4thgeneration firmware</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/14" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-15" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="15">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-15-id" class="item-cell-id">
                                                <div>15</div>
                                            </td>
                                            <td id="albums-item-15-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-15-slug" class="item-cell-slug">
                                                <div>robust-zerotolerance-frame</div>
                                            </td>
                                            <td id="albums-item-15-name" class="item-cell-name">
                                                <div>Robust zerotolerance frame</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/15" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-16" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="16">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-16-id" class="item-cell-id">
                                                <div>16</div>
                                            </td>
                                            <td id="albums-item-16-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-16-slug" class="item-cell-slug">
                                                <div>customizable-optimal-database</div>
                                            </td>
                                            <td id="albums-item-16-name" class="item-cell-name">
                                                <div>Customizable optimal database</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/16" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-17" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="17">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-17-id" class="item-cell-id">
                                                <div>17</div>
                                            </td>
                                            <td id="albums-item-17-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-17-slug" class="item-cell-slug">
                                                <div>secured-transitional-time-frame</div>
                                            </td>
                                            <td id="albums-item-17-name" class="item-cell-name">
                                                <div>Secured transitional time-frame</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/17" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-18" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="18">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-18-id" class="item-cell-id">
                                                <div>18</div>
                                            </td>
                                            <td id="albums-item-18-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-18-slug" class="item-cell-slug">
                                                <div>re-engineered-scalable-model</div>
                                            </td>
                                            <td id="albums-item-18-name" class="item-cell-name">
                                                <div>Re-engineered scalable model</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/18" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-19" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="19">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-19-id" class="item-cell-id">
                                                <div>19</div>
                                            </td>
                                            <td id="albums-item-19-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-19-slug" class="item-cell-slug">
                                                <div>mandatory-multi-tasking-encoding</div>
                                            </td>
                                            <td id="albums-item-19-name" class="item-cell-name">
                                                <div>Mandatory multi-tasking encoding</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/19" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr id="albums-item-20" class="">
                                            <td class="item-bulk-cell">
                                                <label class="styled-checkbox">
                                                    <input type="checkbox" value="20">
                                                    <div class="styled-checkbox-indicator"></div>
                                                </label>
                                            </td>
                                            <td id="albums-item-20-id" class="item-cell-id">
                                                <div>20</div>
                                            </td>
                                            <td id="albums-item-20-created-at" class="item-cell-created-at">
                                                <div class="display-datetime">7/21/2019, 3:00 AM</div>
                                            </td>
                                            <td id="albums-item-20-slug" class="item-cell-slug">
                                                <div>persistent-bottom-line-moderator</div>
                                            </td>
                                            <td id="albums-item-20-name" class="item-cell-name">
                                                <div>Persistent bottom-line moderator</div>
                                            </td>
                                            <td class="table-item-actions">
                                                <div class="btn-group btn-group-xs nowrap"><a href="/entity/albums/item/20" class="btn btn-primary"><i class="fas fa-edit"></i></a>
                                                    <div class="btn btn-danger"><i class="fas fa-trash"></i></div>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                    <!---->
                                </table>
                            </div>
                            <nav class="pager-wrapper box-footer">
                                <!---->
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