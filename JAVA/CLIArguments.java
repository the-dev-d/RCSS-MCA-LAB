class CLIArguments {
	
	public static void main(String args[]) {


		if(args.length < 2) {
			System.out.println("Enter 2 numbers on executing");
			return;
		}

		System.out.println(args[0] + " and "+ args[1]);

		return;
	}
}