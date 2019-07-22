var sidebar = Vue.component("Sidebar", {
    template:
        `<div class="sidebar">
  <nav class="sidebar-nav ps">
    <ul class="nav">
      <li class="nav-item">
        <a class="nav-link" @click="route('/logout')">
          <i class="nav-icon icon-speedometer"></i> Logout
        </a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" @click="route('/view/search')"><i class="nav-icon icon-direction"></i> 책 검색</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" @click="route('/view/search')"><i class="nav-icon icon-direction"></i> 검색 키워드 통계</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" @click="route('/view/search')"><i class="nav-icon icon-direction"></i> 유저 검색기록</a>
      </li>
      
    </ul>
  <div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; right: 0px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 0px;"></div></div></nav>
</div>`
    ,
    props: []
    , data : function(){
        return { email:''
            , password:''
        };
    }
    , methods : {
        route : function(path){
            router.push(path)
        }
    }
});