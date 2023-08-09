<script>
import axios from 'axios'
    export default{
        data() {
            return {
                styleBtn1: true,
                items:[],
                path:'find-all',
                role:'item',
                namaItem:'',
                hargaSatuan:'',
                selectOption:''
            };
        },
        mounted(){
            this.fetchItems();
        },
        methods: {
            addOption() {
                this.styleBtn1 = !this.styleBtn1;
            },
            logout(){
                // <LoginVue/>
                console.log(this.items);
            },
            addNamaItem(){
                this.path = 'find-item-by-nama/' + this.namaItem 
                this.namaItem = ''
            },
            addHargaSatuan(){
                this.hargaSatuan = ''
            },
            handleJenis(){
                this.role = 'item'
                if(this.selectOption == 'tidak ada'){
                    this.path = 'find-all'
                }else{
                    this.path = 'find-item-by-unit/' + this.selectOption
                }
                this.fetchItems();
            },
            handleFindHarga(){
                this.role = 'item'
                if(this.hargaSatuan == ''){
                    this.path = 'find-all'
                }else{
                    this.path = 'find-item-by-harga/' + this.hargaSatuan
                }
                this.fetchItems();
            },
            handleFindNama(){
                this.role = 'item'
                if(this.namaItem == ''){
                    this.path = 'find-all'
                }else{
                    this.path = 'find-item-by-nama/' + this.namaItem
                }
                this.fetchItems();
            },
            handleAddItem(){

            },
            fetchItems() {
                axios
                .get('http://localhost:8080/api/' + this.role +'/' + this.path) // Ganti dengan endpoint yang sesuai
                .then(response => {
                    // Mengambil objek data dari respons
                    const responseData = response.data.data;

                    // Menyimpan objek data ke dalam variabel items
                    this.items = responseData;

                })
                .catch(error => {
                    console.error('Error fetching items:', error);
                });
            }
        }
    }
</script>

<template>
    <div id="custom">
        <!-- Bagian Header -->
        <header>
            <img id="img-logo" src="data:image/jpeg;base64,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" alt="Rimba">
            <h3>Customer</h3>
            <div>
                <label>Find by Nama : </label>
                <input type="text" v-model="namaItem" style="width: 100px">
                <button @click="handleFindNama">Cari</button>
            </div>
            <div>
                <label>Find by Harga : </label> 
                <input type="number" v-model="hargaSatuan" style="width: 100px">
                <button @click="handleFindHarga">Cari</button>
            </div>
            <div>
                <label>Find by Jenis : </label>
                <select v-model="selectOption" @change="handleJenis">
                    <option value="tidak ada"></option>
                    <option value="pcs">pcs</option>
                    <option value="kg">kg</option>
                </select>
            </div>
            <button @click="handleAddItem">Tambah Product</button>
            <div id="account">
                <button v-on:click="logout">Log-Out</button>
            </div>
        </header>

        <!-- Bagian Main -->
        <h3>Our Product's</h3>
        <main>
            <div id="product-role">
                <div v-for="item in items" :key="item.id" class="product">
                    <img :src="item.barangImage" alt="item.namaItem">
                    <h3>{{ item.namaItem }}</h3>
                    <p>Jenis Barang: {{item.unit}}</p>
                    <p>Stok Barang : {{item.stok}}</p>
                    <p>Harga : {{item.hargaSatuan}}</p>
                    <button>Edit</button>
                    <button>Delete</button>
                    <button>Beli</button>
                </div>
            </div>
            <div id="sales-role">

            </div>
        </main>

        <!-- Bagian Footer -->
        <footer>
            <label>Copyright by Farhan Ramadhan Muchtar</label>
        </footer> 
    </div>
</template>

<style>
    #custom{
        text-align: center;
    }

    header{
        height: 5rem;
        display: flex;
        padding: 4px 1rem;
        justify-content: space-between;
        align-items: center;
        background:#E6E6FA;
    }

    #img-logo{
        width: 70px;
        height: fit-content;
    }

    #account{
        padding-right: 1.5rem;
    }

    main{
        padding: 0.5rem 5rem;
        align-items: center;
        max-width:max-content;
        min-height: 61.5vh;
    }

    #product-role{
        display: grid;
        gap: 2rem;
        grid-template-columns: repeat(4,1fr);
    }

    .product{
        width: 250px;
        height: fit-content;
        background: darkseagreen;
        padding: 20px 0;
    }

    img{
        width: 200px;
        height: 200px;
    }

    #option{
        gap: 0.5rem;
        display: flex;
        padding-left: 70%;
    }

    button{
        height: 2rem;
        padding: 0.5rem 1rem;
        background: white;
        border-radius: 5px;
        border: 1px solid black;
        cursor: pointer;
    }

    table{
        border-collapse: collapse;
        border: 1px solid #cccccc;
    }

    thead,tbody,tr,td,th{
        border: 1px solid #cccccc;
    }

    th{
        background-color: dodgerblue;
        padding: 4px 8px;
        height: 2rem;
    }

    td{
        padding: 4px 8px;
        height: 2rem;
    }

    footer{
        margin-top: 1rem;
        height: 5rem;
        display: flex;
        color: aliceblue;
        align-items: center;
        justify-content: center;
        background-color: #424242;
    }
</style>