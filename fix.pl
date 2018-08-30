use strict;
use warnings;
my @files = glob "./*.java";
foreach my $file (@files) {
	rename $file, $file . ".bak";
	open IN, "<" . $file . ".bak";
	open OUT, ">" . $file;
	while(<IN>) {
		my $nn = substr $file, 2, -5;
		$_ =~ s/^public class .+ \{/public class $nn \{/;
		print OUT $_;
	}
	close IN;
	close OUT;
}