var login = Vue.component("Login", {
    template:
        `<div class="login-box">
            <div class="login-logo" style="color: white;">Book<b>Book</b></div>
            <div class="login-box-body">
            <p class="login-box-msg">
                <span>Authenticate to continue</span>
            </p>
            <form action="/auth/login" method="post">
                <div class="form-group has-feedback">
                    <input placeholder="email" class="form-control" v-model="email" name="username">
                </div>
                <div class="form-group has-feedback">
                    <input type="password" placeholder="Password" class="form-control" v-model="password" name="password">
                </div>
                <div class="row">
                    <div class="col-xs-4">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">Login</button>
                    </div>
                    <div class="col-xs-4 pull-right">
                        <button type="button" @click.prevent="signup" class="btn btn-primary btn-block btn-flat">Join</button>
                    </div>
                </div>
            </form>
        </div>
    </div>`
    ,
    props: []
    , data : function(){
        return { email:'', password:''};
    }
    , methods : {
        submit : function(){

            var params = new URLSearchParams();
            params.append('username', this.email);
            params.append('password', this.password);

            axios.post('/auth/login'
                , params
                , { withCredentials: true}
            )
            .then(function(res) {
                router.push('/view/search')
            }, function() {
                console.error(arguments);
            });
        },
        signup : function(){
            router.push('/view/signup');
        }
    }
});